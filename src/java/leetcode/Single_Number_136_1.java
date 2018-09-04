package leetcode;

/**
 * @author goloschy
 */

public class Single_Number_136_1
{
  public int singleNumber(int[] nums)
  {
    int result = 0;
    for (int i=0; i<nums.length; i++)
    {
      result = result ^ nums[i];
    }
    return result;
  }
}
