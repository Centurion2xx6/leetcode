package java.leetcode;

/**
 * @author goloschy
 */
public class Power_of_Three_326
{
  public boolean isPowerOfThree(int n)
  {
    if (n <= 0)
    {
      return false;
    }

    if (n == 1)
    {
      return true;
    }

    return n >= 3
        && (Integer.numberOfTrailingZeros(n) / 2.0 == (Integer.numberOfTrailingZeros(n) >> 1));
  }
}
