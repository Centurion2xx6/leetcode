package leetcode;

/**
 * @author goloschy
 */
public class Power_of_Two_231
{
  public boolean isPowerOfTwo(int n) {
    if (n < 1)
    {
      return false;
    }

    return (n&(n-1)) == 0;
  }
}
