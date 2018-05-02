package main.leetcode;

/**
 * @author goloschy
 * 1 ms
 */
public class Find_the_Duplicate_Number_287_2
{
  public int findDuplicate(int[] nums)
  {
    byte[] existingNums = new byte[nums.length];
    for (int i=0; i<nums.length; i++)
    {
      if (existingNums[nums[i]]==1)
      {
        return nums[i];
      }
      else
      {
        existingNums[nums[i]] = 1;
      }
    }

    return 0;
  }
}
