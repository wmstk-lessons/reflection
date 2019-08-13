package password;

public class PasswordGeneratorSecond implements PasswordGenerator
{
  static
  {
    System.out.println("PasswordGeneratorSecond loaded");
  }

  @Override
  public String generate()
  {
    return "second password";
  }
}
