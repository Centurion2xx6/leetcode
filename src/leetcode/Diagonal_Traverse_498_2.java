package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Diagonal_Traverse_498_2
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


    Assert.assertArrayEquals(
        findDiagonalOrder(new int[][]{
                        new int[]{3},
                        new int[]{2}}),
        new int[]{3,2});
  }


  public int[] findDiagonalOrder(int[][] matrix)
  {
    if (matrix[0] == null)
    {
      return new int[]{};
    }

    int mSize = matrix.length * matrix[0].length;
    int[] result = new int[mSize];
    int resInd = 0;

    boolean neDirection = true;

    int m = 0;
    int n = 0;

    int maxM = matrix.length - 1;
    int maxN = matrix[0].length - 1;
    for (int i = 0; i <= maxM + maxN; i++)
    {
      if (neDirection)
      {
        n = Math.max(0, i - maxN);
        m = i - n;
        while (n <= maxN
            && m >= 0
            && m <= maxM)
        {
          result[resInd] = matrix[m][n];
          resInd++;

          n++;
          m = i - n;
        }
      }
      else
      {
        m = Math.max(0, i - maxM);
        n = i - m;
        while (m <= maxM
            && n >= 0
            && n <= maxN)
        {
          result[resInd] = matrix[m][n];
          resInd++;

          m++;
          n = i - m;
        }
      }
      neDirection = !neDirection;
    }

    return result;
  }
}
