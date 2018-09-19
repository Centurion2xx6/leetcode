package leetcode;

public class Binary_Search_704
{
  public Binary_Search_704()
  {
  }

  int[] nums;
  int target;

  public int search(int[] nums, int target)
  {
    if (nums[0] > target || nums[nums.length - 1] < target)
    {
      return -1;
    }

    this.nums = nums;
    this.target = target;
    return recursiveSearch(0, nums.length - 1);
  }

  public int recursiveSearch(int rangeStart, int rangeEnd)
  {
    if (rangeStart == rangeEnd)
    {
      if (nums[rangeStart] == target)
      {
        return rangeStart;
      }
      else
      {
        return -1;
      }
    }

    int rangeMid = (rangeStart + rangeEnd) / 2;
    if (nums[rangeMid] == target)
    {
      return rangeMid;
    }

    if (nums[rangeMid] > target)
    {
      return recursiveSearch(rangeStart, rangeMid);
    }
    else
    {
      return recursiveSearch(rangeMid + 1, rangeEnd);
    }
  }
}
