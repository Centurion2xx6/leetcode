package main.leetcode;

public class FindMedianSortedArrays_4
{
  public static void main(String[] args)
  {
    int[] nums1 = new int[]{1, 2, 3};
    int[] nums2 = new int[]{3, 4, 5, 6, 7};

    System.out.println(new FindMedianSortedArrays_4().findMedianSortedArrays(nums1, nums2));
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2)
  {
    if (nums1 == null || nums2 == null)
    {
      if (nums1 != null)
      {
        return getMedian(nums1);
      }
      else if (nums2 != null)
      {
        getMedian(nums2);
      }
      else
      {
        return 0;
      }
    }
    int[] nums = new int[nums1.length + nums2.length];
    int i = 0;
    int j = 0;
    int ij = 0;
    while (i < nums1.length || j < nums2.length)
    {
      ij = i + j;
      if (i == nums1.length)
      {
        nums[ij] = nums2[j];
        j++;
        continue;
      }
      else if (j == nums2.length)
      {
        nums[ij] = nums1[i];
        i++;
        continue;
      }
      if (nums1[i] < nums2[j])
      {
        nums[ij] = nums1[i];
        i++;
      }
      else
      {
        nums[ij] = nums2[j];
        j++;
      }
    }
    return getMedian(nums);
  }

  private static double getMedian(int[] nums)
  {
    double half = nums.length/2.0;
    if (Double.compare(Math.round(half), half) != 0)
    {
      return nums[(int)Math.floor(half)];
    }
    else
    {
      return (nums[(int)Math.round(half-1)]+nums[(int)Math.round(half)])/2.0;
    }
  }
}
