package java.leetcode;

public class UglyNumber_263_3
{
  public static void main(String[] args)
  {
    //System.out.println(isUgly(2));
    System.out.println(isUgly(214797179));
  }
  
  public static boolean isUgly(int num) 
  {
    if (num == 1)
    {
      return true;
    }
    if (num <= 0)
    {
      return false;
    }
    // divide by 2
    while ((num&1) == 0)
    {
      num = num >> 1;
    }
    // divide by 5
    while (String.valueOf(num).endsWith("5"))
    {
      num /= 5;
    }
    // divide by 3
    String numStr = String.valueOf(num);
    while (numStr.endsWith("3") || numStr.endsWith("9") || numStr.endsWith("1") || numStr.endsWith("7"))
    {
      if (num % 3 == 0)
      {
        num /= 3;
      }
      else
      {
        break;
      }
    }
    return num == 1;
  }
}
