package java.leetcode;

import java.util.Arrays;

/**
 * @author goloschy
 * 6 ms
 */
public class Find_the_Duplicate_Number_287
{
  public int findDuplicate(int[] nums)
  {
    Arrays.sort(nums);
    for (int i=0; i<nums.length-1; i++)
    {
      if (nums[i] == nums[i+1])
      {
        return nums[i];
      }
    }
    return 0;
  }
}
