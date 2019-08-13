package firma;

import java.io.IOException;

public class FirmaMain
{
  public static void main(String[] args)
  {
    final FirmaPasswordFactory firmaPasswordFactory;
    try
    {
      firmaPasswordFactory=new FirmaPasswordFactory();
      final String password=firmaPasswordFactory.getPassword();
      System.out.println(password);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

  }
}
