package java.leetcode;

/**
 * Created by goloschy on 4/28/2017.
 */
public class Add_Strings_415
{
  public static void main(String[] args)
  {
    String num1 = "12";//312321321";
    String num2 = "123";//1111111111113333333333333333333333333333333333333333333333333333333333333332222222222222222222222222333332321321";
    System.out.println(addStrings(num1, num2));
  }

  public static String addStrings(String num1, String num2)
  {
    int num1cursor = num1.length();
    int num2cursor = num2.length();

    String result = "";

    int overflow = 0;
    while (num1cursor > 0 || num2cursor > 0)
    {
      int num1Int = --num1cursor >= 0 ? Character.getNumericValue(num1.charAt(num1cursor)) : 0;
      int num2Int = --num2cursor >= 0 ? Character.getNumericValue(num2.charAt(num2cursor)) : 0;

      int curRes = num1Int + num2Int + overflow;

      if (curRes > 9)
      {
        curRes = curRes - 10;
        overflow = 1;
      }
      else
      {
        overflow = 0;
      }

      result = curRes + result;
    }
    if (overflow == 1)
    {
      result = overflow + result;
    }

    return result;
  }
}
