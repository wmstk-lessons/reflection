package password;

public class PasswordGeneratorFirst implements PasswordGenerator
{
  static
  {
    System.out.println("PasswordGeneratorFirst loaded");
  }

  @Override
  public String generate()
  {
    return "first password";
  }
}
