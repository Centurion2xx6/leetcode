package java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author goloschy
 */

public class Average_of_Levels_in_Binary_Tree_637
{
  public static void main(String[] args)
  {
    TreeNode node = new TreeNode(0);
    node.left = new TreeNode(1);
    node.right = new TreeNode(2);
    node.right.right = new TreeNode(4);
    node.right.right.left = new TreeNode(6);
    node.right.right.right = new TreeNode(7);

    List<Double> l = new Average_of_Levels_in_Binary_Tree_637().averageOfLevels(node);
  }

  List<Long> sums = new ArrayList<>();
  List<Integer> counts = new ArrayList<>();
  public List<Double> averageOfLevels(TreeNode root)
  {
    addNodeValue(root, 0);
    List<Double> result = new ArrayList<>();
    for (int i=0; i<sums.size(); i++)
    {
      result.add(1.0 * sums.get(i) / counts.get(i));
    }
    return result;
  }

  public void addNodeValue(TreeNode node, int level)
  {
    if (node == null)
    {
      return;
    }

    if (sums.size() <= level)
    {
      sums.add((long) node.val);
      counts.add(1);
    }
    else
    {
      sums.set(level, sums.get(level) + node.val);
      counts.set(level, counts.get(level) + 1);
    }

    addNodeValue(node.left, level+1);
    addNodeValue(node.right, level+1);
  }
}
