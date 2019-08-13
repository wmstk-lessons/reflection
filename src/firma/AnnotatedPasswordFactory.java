package firma;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class AnnotatedPasswordFactory
{
  private final Properties properties=new Properties();

  AnnotatedPasswordFactory() throws IOException
  {
    properties.load(FirmaPasswordFactory.class.getClassLoader().getResourceAsStream("generatorAnn.properties"));
  }

  public String getPassword()
  {
    try
    {
      final String sign=getGenerator();
      final Class<?> clazz=Class.forName(sign);
      System.out.println(clazz.getName());
      for (final Method method : clazz.getMethods())
      {
        if (method.getAnnotation(Generate.class) != null)
        {
          final Object generator=clazz.newInstance();
          return (String) method.invoke(generator);
        }
      }
    }
    catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e)
    {
      throw new RuntimeException(e);
    }
    throw new RuntimeException("No annotation");
  }

  private String getGenerator()
  {
    return properties.getProperty("generator");
  }

}
