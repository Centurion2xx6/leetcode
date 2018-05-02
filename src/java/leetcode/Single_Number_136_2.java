package main.leetcode;

import java.util.HashSet;

/**
 * @author goloschy
 */

public class Single_Number_136_2
{
  public int singleNumber(int[] nums)
  {
    HashSet<Integer> hs = new HashSet<>();
    for (int i = 0; i < nums.length; i++)
    {
      if (!hs.contains(nums[i]))
      {
        hs.add(nums[i]);
      }
      else
      {
        hs.remove(nums[i]);
      }
    }
    return hs.iterator().next();
  }
}
