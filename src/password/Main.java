package password;

public class Main
{
  public static void main(String[] args)
  {
    final PasswordGenerator pgf=new PasswordGeneratorFirst();
    final String pass=pgf.generate();
    System.out.println(pass);
  }
}
