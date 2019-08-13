package password;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

class PasswordGeneratorReflectionFactory
{
  PasswordGenerator getPasswordGenerator()
  {
    try
    {
      final String sign=getGenerator();
      final Class clazz=Class.forName(sign);
      final Object instance=clazz.newInstance();
      return (PasswordGenerator) instance;
    }
    catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e)
    {
      throw new RuntimeException(e);
    }
  }

  private String getGenerator() throws IOException
  {
    final Properties properties=new Properties();
    properties.load(PasswordGeneratorFactory.class.getClassLoader().getResourceAsStream("generatorRefl.properties"));
    return properties.getProperty("generator");
  }
}
