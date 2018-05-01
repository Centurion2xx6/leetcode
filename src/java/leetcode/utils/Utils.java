package leetcode.utils;

import leetcode.TreeNode;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Map;

public class Utils
{
  public static TreeNode arrToTree(Integer[] ints)
  {
    return new Utils().new ArrToTreeConverter(ints).arrToTree(0, 0);
  }
  class ArrToTreeConverter
  {
    private final Integer[] ints;
    ArrToTreeConverter(Integer[] ints)
    {
      this.ints = ints;
    }

    private TreeNode arrToTree(int index, int height)
    {
      if (ints.length < index+1 || ints[index] == null)
      {
        return null;
      }

      TreeNode res = new TreeNode(ints[index]);
      int basePower = (int) Math.floor(Math.sqrt(index+1)) - 1;
      int baseInd = 0;
      for (int i=0; i<=basePower; i++)
      {
        baseInd += 2*basePower;
      }
      int leftInd = baseInd + 2*(basePower+1) + (index - baseInd - 1)*2 + 1;

      //int leftInd = index + (int) Math.pow(2, height);
      int rightInd = leftInd+1;

      res.left = arrToTree(leftInd, height+1);
      res.right = arrToTree(rightInd, height+1);
      return res;
    }
  }


  public static void print(char[][] a)
  {
    if (a == null)
    {
      return;
    }
    for (int x = 0; x < a.length; x++)
    {
      for (int y = 0; y < a[0].length; y++)
      {
        // just a print so it does not make new lines for every char
        System.out.print(a[x][y]);
      }
      // new line once one column (board[x][0] - board[x][8]) is printed
      // note: you proably want to turn around the x and y above since
      // I guess you want to print rows instead of columns
      System.out.println();
    }
    System.out.println("------------------");
  }
  public static void print(Object[][] a)
  {
    if (a == null)
    {
      return;
    }
    for (int x = 0; x < a.length; x++)
    {
      for (int y = 0; y < a[0].length; y++)
      {
        // just a print so it does not make new lines for every char
        System.out.print(a[x][y]);
      }
      // new line once one column (board[x][0] - board[x][8]) is printed
      // note: you proably want to turn around the x and y above since
      // I guess you want to print rows instead of columns
      System.out.println();
    }
    System.out.println("------------------");
  }
  public static void print(TreeNode node)
  {
    ArrayDeque<Map.Entry<Integer, TreeNode>> queue = new ArrayDeque<>();
    queue.add(new AbstractMap.SimpleEntry<>(0, node));
    int lastHeight = 0;
    while (!queue.isEmpty())
    {
      Map.Entry<Integer, TreeNode> q = queue.pop();
      if (q.getKey() != lastHeight)
      {
        System.out.println();
        lastHeight++;
      }
      TreeNode n = q.getValue();
      if (n == null)
      {
        System.out.print("-");
      }
      else
      {
        System.out.print(n.val);
        queue.add(new AbstractMap.SimpleEntry<>(lastHeight+1, n.left));
        queue.add(new AbstractMap.SimpleEntry<>(lastHeight+1, n.right));
      }
      System.out.print(" ");
    }
  }
}
