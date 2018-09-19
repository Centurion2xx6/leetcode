package java.leetcode;

/*
  @author goloschy
 */
public class Number_of_1_Bits_191
{
  // you need to treat n as an unsigned value
  public int hammingWeight(int n)
  {
    short res = 0;
    while (n != 0)
    {
      res += n & 1;
      n = n >>> 1;
    }
    return res;
  }
}
