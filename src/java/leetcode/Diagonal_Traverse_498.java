package java.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Diagonal_Traverse_498
{
  @Test
  public void test()
  {
    int[][] testData = new int[][]{
        new int[]{1,2,3},
        new int[]{4,5,6},
        new int[]{7,8,9}};

    System.out.println(Arrays.toString(findDiagonalOrder(testData)));
    Assert.assertArrayEquals(
        findDiagonalOrder(testData),
        new int[]{1,2,4,7,5,3,6,8,9});
  }

  private int m, n = 0;

  private short mAdd = -1;
  private short nAdd = +1;
  boolean postInverse = false;

  private int maxM, maxN = 0;

  public int[] findDiagonalOrder(int[][] matrix)
  {
    int mSize = matrix.length * matrix[0].length;

    maxM = matrix.length - 1;
    maxN = matrix[0].length - 1;

    int[] result = new int[mSize];
    for (int i = 0; i < mSize; i++)
    {
      result[i] = matrix[m][n];
      setNextIndex();
    }
    return result;
  }

  private void setNextIndex()
  {
    m += mAdd;
    n += nAdd;
    postInverse = false;
    if (m < 0)
    {
      m = 0;
      postInverse = true;
    }
    if (n < 0)
    {
      n = 0;
      postInverse = true;
    }
    if (m > maxM)
    {
      m = maxM;
      postInverse = true;
    }
    if (n > maxN)
    {
      n = maxN;
      postInverse = true;
    }

    if (postInverse)
    {
      inverseDirection();
    }
  }

  private void inverseDirection()
  {
    mAdd *= -1;
    nAdd *= -1;
  }
}
