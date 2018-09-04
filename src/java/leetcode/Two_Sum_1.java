package leetcode;

import java.util.HashMap;

/***
 * @author goloschy
 */

public class Two_Sum_1
{
  public int[] twoSum(int[] nums, int target)
  {
    HashMap<Integer, Integer> elementIndexes = new HashMap<>();
    for (int i=0; i<nums.length; i++)
    {
      int diff = target-nums[i];
      Integer diffIndex = elementIndexes.get(diff);
      if (diffIndex != null)
      {
        return new int[]{diffIndex, i};
      }
      else
      {
        elementIndexes.put(nums[i], i);
      }
    }
    return null;
  }
}
