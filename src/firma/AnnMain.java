package firma;

import java.io.IOException;

public class AnnMain
{
  public static void main(String[] args)
  {
    try
    {
      final AnnotatedPasswordFactory factory=new AnnotatedPasswordFactory();
      final String password=factory.getPassword();
      System.out.println(password);
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }
}
