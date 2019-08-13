package password;

public class MainWithFactory
{
  public static void main(String[] args)
  {
    final PasswordGenerator psg=new PasswordGeneratorFactory().getPasswordGenerator();
    System.out.println(psg.generate());
  }
}
