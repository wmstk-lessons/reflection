package password;

import java.io.IOException;
import java.util.Properties;

class PasswordGeneratorFactory
{
  PasswordGenerator getPasswordGenerator()
  {
    try
    {
      final String sign=getGenerator();
      if ("first".equals(sign))
      {
        return new PasswordGeneratorFirst();
      }
      return new PasswordGeneratorSecond();
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  private String getGenerator() throws IOException
  {
    final Properties properties=new Properties();
    properties.load(PasswordGeneratorFactory.class.getClassLoader().getResourceAsStream("generator.properties"));
    return properties.getProperty("generator");
  }
}
