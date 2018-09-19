package java.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PerfectRectangle_391
{
  public static void main(String[] args)
  {
    System.out.println(isRectangleCover( new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}}));
  }
  public static boolean isRectangleCover(int[][] rectangles) 
  {
    // a rectangle area is divided into cells. 
    //Each of cells is represented by bottom left coordinate in a string format
    // "1,2" means area of a cell (x=1, y=2) to (x=2, y=3)   
    Map<String, Integer> totalAreaCoverage = new HashMap<>();
    for (int[] rectangle : rectangles)
    {
      for (String cellAreaCoverage : getSquareArea(rectangle))
      {
        if (totalAreaCoverage.put(cellAreaCoverage, 1) != null) // already covered -> is overlap
        {
          return false;
        }
      }
    }
    
    int[] maxPossibleTotalRectangle = getMaxPossibleTotalRectangle(rectangles);
    return totalAreaCoverage.keySet().equals( getSquareArea(maxPossibleTotalRectangle) );
  }
  private static Set<String> getSquareArea(int[] rectangle)
  {
    Set<String> area = new HashSet<String>();
    for (int x = rectangle[0]; x<rectangle[2]; x++)
    {
      for (int y = rectangle[1]; y<rectangle[3]; y++)
      {
        area.add(x+","+y);
      }      
    }
    return area;
  }
  private static int[] getMaxPossibleTotalRectangle(int[][] rectangles)
  {
    TreeSet<Integer> minX = new TreeSet<>();
    TreeSet<Integer> minY = new TreeSet<>();
    TreeSet<Integer> maxX = new TreeSet<>();
    TreeSet<Integer> maxY = new TreeSet<>();
    for (int[] rect : rectangles)
    {
      minX.add(rect[0]);
      minY.add(rect[1]);
      maxX.add(rect[2]);
      maxY.add(rect[3]);
    }
    return new int[]{minX.first(), minY.first(), maxX.last(), maxY.last()};
  }
}
