package firma;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class FirmaPasswordFactory
{
  private final Properties properties=new Properties();

  FirmaPasswordFactory() throws IOException
  {
    properties.load(FirmaPasswordFactory.class.getClassLoader().getResourceAsStream("generatorFirma.properties"));
  }

  public String getPassword()
  {
    try
    {
      final String sign=getGenerator();
      final Class<?> clazz=Class.forName(sign);
      System.out.println(clazz.getName());
      final Object generator=clazz.newInstance();
      final Method method=clazz.getMethod(getMethod());
      final Object invoke=method.invoke(generator);
      System.out.println(method.getName());
      return (String) invoke;
    }
    catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e)
    {
      throw new RuntimeException(e);
    }
  }

  private String getGenerator()
  {
    return properties.getProperty("generator");
  }

  private String getMethod()
  {
    return properties.getProperty("method");
  }
}
