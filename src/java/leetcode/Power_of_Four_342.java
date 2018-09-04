package leetcode;

public class Power_of_Four_342
{
  public static void main(String[] args)
  {
    System.out.println(isPowerOfFour2(64));
    System.out.println(isPowerOfFour2(1));
    System.out.println(isPowerOfFour2(-16));
    System.out.println(isPowerOfFour2(16));
    System.out.println(isPowerOfFour2(15));
    System.out.println(isPowerOfFour2(4));
    System.out.println(isPowerOfFour2(8));
    System.out.println(isPowerOfFour2(32));
    System.out.println(isPowerOfFour2(1073741825));
  }

  public static boolean isPowerOfFour(int num)
  {
    return num > 0
        &&
        (
            num == 1 ||
                (num & 1) == 0 && ((num >> 1) & 1) == 0 && (num & (num - 1)) == 0
        );
  }

  public static boolean isPowerOfFour2(int num)
  {
    if (num <= 0)
    {
      return false;
    }

    if (num == 1)
    {
      return true;
    }

    return num >= 4
        && (num & (num - 1)) == 0
        && (Integer.numberOfTrailingZeros(num) / 2.0 == (Integer.numberOfTrailingZeros(num) >> 1));
  }
}
