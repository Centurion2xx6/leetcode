package java.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author goloschy
 */

public class Surrounded_Regions_130_2
{
  final static char X = 'X';
  final static char O = 'O';
  static short[][] notSurroundedCells = null;

  static int rows = 0;
  static int cols = 0;

  static Queue<Integer[]> cellsToProcessQueue = new ArrayDeque<>();

  public void solve(char[][] board)
  {
    if (board == null)
    {
      return;
    }

    rows = board.length;
    if(rows < 3)
    {
      return;
    }

    cols = board[0].length;
    if(cols < 3)
    {
      return;
    }

    notSurroundedCells = new short[rows][cols];
    for (int i = 0; i < rows; i++)
    {
      cellsToProcessQueue.add(new Integer[]{i, 0});
      cellsToProcessQueue.add(new Integer[]{i, cols-1});
    }
    for (int i = 0; i < cols; i++)
    {
      cellsToProcessQueue.add(new Integer[]{0, i});
      cellsToProcessQueue.add(new Integer[]{rows-1, i});
    }

    while (!cellsToProcessQueue.isEmpty())
    {
      Integer[] rowCol = cellsToProcessQueue.poll();
      markAsNotSurrounded(board, rowCol[0], rowCol[1]);
    }

    // start from 1 and end with -1 because border cells cannot be surrounded
    for (int row = 1; row < rows-1; row++)
    {
      for (int col = 1; col < cols-1; col++)
      {
        if (board[row][col] == O && notSurroundedCells[row][col] != 1)
        {
          board[row][col] = X;
        }
      }
    }
  }

  private static void markAsNotSurrounded(char[][] board, int row, int col)
  {
    if (isOutOfBounds(row, col))
    {
      return;
    }

    if (notSurroundedCells[row][col] == 1)
    {
      // already checked this cell
      return;
    }

    if (board[row][col] == O)
    {
      notSurroundedCells[row][col] = 1;
      cellsToProcessQueue.add(new Integer[]{row-1, col});
      cellsToProcessQueue.add(new Integer[]{row+1, col});
      cellsToProcessQueue.add(new Integer[]{row, col-1});
      cellsToProcessQueue.add(new Integer[]{row, col+1});
    }
  }

  private static boolean isOutOfBounds(int row, int col)
  {
    return row < 0 || col < 0 || row > rows-1 || col > cols-1;
  }
}
