package leetcode;

public class Validate_Binary_Search_Tree_98
{
  public boolean isValidBST(TreeNode root)
  {
    return root == null || validateNodeChildsRecursive(root, null, null);
  }

  public boolean validateNodeChildsRecursive(TreeNode node, Integer moreThan, Integer lessThan)
  {
    boolean res = (moreThan == null || moreThan < node.val) && (lessThan == null || node.val < lessThan);
    if (res && node.left != null)
    {
      res = node.val > node.left.val;
    }
    if (res && node.right != null)
    {
      res = node.val < node.right.val;
    }
    if (!res)
    {
      return false;
    }

    if (node.left != null)
    {
      res = validateNodeChildsRecursive(node.left, moreThan, node.val);
    }
    if (res && node.right != null)
    {
      res = validateNodeChildsRecursive(node.right, node.val, lessThan);
    }
    return res;
  }
}
