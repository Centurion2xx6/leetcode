package main.leetcode;

/**
 * @author goloschy
 */

public class Invert_Binary_Tree_226
{
  public TreeNode invertTree(TreeNode root)
  {
    invertChildsRecursive(root);
    return root;
  }

  public void invertChildsRecursive(TreeNode node)
  {
    if (node == null)
      return;

    TreeNode left = node.left;
    node.left = node.right;
    node.right = left;

    invertChildsRecursive(node.left);
    invertChildsRecursive(node.right);
  }
}
