package password;

public class MainWithReflectionFactory
{
  public static void main(String[] args)
  {
    final PasswordGenerator psg=new PasswordGeneratorReflectionFactory().getPasswordGenerator();
    System.out.println(psg.generate());
  }
}
