package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by goloschy on 6/6/2017.
 */
public class SpiralMatrix_54
{
  public static void main(String[] args)
  {
    System.out.println(new SpiralMatrix_54().spiralOrder(new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,9}})
    );

    System.out.println(new SpiralMatrix_54().spiralOrder(new int[][]{
        {1}})
    );

    System.out.println(new SpiralMatrix_54().spiralOrder(new int[][]{
        {1,2,3}})
    );

    System.out.println(new SpiralMatrix_54().spiralOrder(new int[][]{
        {1,2},
        {4,5},
        {7,8}})
    );

    System.out.println(new SpiralMatrix_54().spiralOrder(new int[][]{
        {1},
        {4},
        {7}})
    );

    System.out.println(new SpiralMatrix_54().spiralOrder(new int[][]{
        {1,2,3,11},
        {4,5,6,22},
        {7,8,9,33}})
    );
  }

  public List<Integer> spiralOrder(int[][] matrix)
  {
    if (matrix == null)
    {
      return null;
    }

    List<Integer> res = new ArrayList<Integer>();
    int rMin = 0;
    int rMax = matrix.length-1;
    int cMin = 0;
    int cMax = matrix[0].length-1;

    int allItems = matrix.length * matrix[0].length;
    int resSize = 0;

    int rCurrent = 0;
    int cCurrent = 0;

    int rDirection = 0;
    int cDirection = +1;
    while (resSize < allItems)
    {
      res.add(matrix[rCurrent][cCurrent]);
      resSize++;

      if (cDirection == +1 && cCurrent == cMax)
      {
        cDirection = 0;
        rDirection = +1;
        rMin++;
      }
      else if (cDirection == -1 && cCurrent == cMin)
      {
        cDirection = 0;
        rDirection = -1;
        rMax--;
      }
      else if (rDirection == +1 && rCurrent == rMax)
      {
        cDirection = -1;
        rDirection = 0;
        cMax--;
      }
      else if (rDirection == -1 && rCurrent == rMin)
      {
        cDirection = +1;
        rDirection = 0;
        cMin++;
      }
      cCurrent += cDirection;
      rCurrent += rDirection;
    }

    return res;
  }
}
