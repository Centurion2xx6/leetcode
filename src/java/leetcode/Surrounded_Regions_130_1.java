package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Surrounded_Regions_130_1
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
      if (rowCol[0] < 0 || rowCol[1] < 0 || rowCol[0] > rows-1 || rowCol[1] > cols-1)
      {
        continue;
      }

      if (notSurroundedCells[rowCol[0]][rowCol[1]] == 1)
      {
        // already checked this cell
        continue;
      }

      if (board[rowCol[0]][rowCol[1]] == O)
      {
        notSurroundedCells[rowCol[0]][rowCol[1]] = 1;
        cellsToProcessQueue.add(new Integer[]{rowCol[0]-1, rowCol[1]});
        cellsToProcessQueue.add(new Integer[]{rowCol[0]+1, rowCol[1]});
        cellsToProcessQueue.add(new Integer[]{rowCol[0], rowCol[1]-1});
        cellsToProcessQueue.add(new Integer[]{rowCol[0], rowCol[1]+1});
      }
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
}
