package java.leetcode;

/**
 * @author goloschy
 */

public class Convert_Sorted_Array_to_Binary_Search_Tree_108
{
  public TreeNode sortedArrayToBST(int[] nums)
  {
    if (nums.length == 0)
      return null;

    TreeNode head = addMiddleToTreeRecursive(nums, 0, nums.length - 1);
    return head;
  }

  private static TreeNode addMiddleToTreeRecursive(int[] arr, int startIndex, int endIndex)
  {
    if (startIndex > endIndex)
      return null;

    int middleInd = (endIndex + startIndex) / 2;
    TreeNode node = new TreeNode(arr[middleInd]);

    node.left = addMiddleToTreeRecursive(arr, startIndex, middleInd - 1);
    node.right = addMiddleToTreeRecursive(arr, middleInd + 1, endIndex);

    return node;
  }
}
