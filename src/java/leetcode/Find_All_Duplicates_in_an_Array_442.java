package java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by goloschy on 4/28/2017.
 */
public class Find_All_Duplicates_in_an_Array_442
{
  public static void main(String[] args)
  {
    int[] given = new int[]{4,3,2,7,8,2,3,1};
    System.out.println(findDuplicates(given));
  }

  private static List<Integer>  findDuplicates(int[] nums) {
    if (nums == null)
    {
      return null;
    }
    byte[] indexNums = new byte[nums.length+1];
    List<Integer> res = new ArrayList<>();
    for (int num : nums)
    {
      if (indexNums[num] == 1)
      {
        res.add(num);
      }
      else
      {
        indexNums[num]++;
      }
    }
    return res;
  }
}
