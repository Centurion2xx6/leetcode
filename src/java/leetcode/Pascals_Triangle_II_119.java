package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author goloschy
 */

public class Pascals_Triangle_II_119
{
  public static void main(String[] args)
  {
    getRow(4).forEach(i -> System.out.println(i));
  }

  public static List<Integer> getRow(int rowIndex)
  {
    List<Integer> result = new ArrayList<>(rowIndex+1);
    for (int i = 0; i <= rowIndex; i++)
    {
      result.add(1);
      int jVal = 1;
      int nextJVal;
      for (int j = 1; j <= i; j++)
      {
        nextJVal = result.get(j-1) + result.get(j);
        result.set(j-1, jVal);
        jVal = nextJVal;
      }
    }
    return result;
  }
}
