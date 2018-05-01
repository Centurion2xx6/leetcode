package leetcode;

import leetcode.utils.Utils;

public class Surrounded_Regions_130
{


  public static void main(String[] args)
  {
    char[][] carr = new char[][]{};
    new Surrounded_Regions_130().solve(carr);
    Utils.print(carr);

    carr = new char[][]{
        {'x','o','x'}};
    new Surrounded_Regions_130().solve(carr);
    Utils.print(carr);

    carr = new char[][]{
        {'x','x','x'},
        {'x','o','x'},
        {'x','o','x'}};
    new Surrounded_Regions_130().solve(carr);
    Utils.print(carr);

    carr = new char[][]{
        {'x','x','x'},
        {'x','o','x'},
        {'x','x','x'}};
    new Surrounded_Regions_130().solve(carr);
    Utils.print(carr);

    carr = new char[][]{
        {'x','x','x','x'},
        {'x','o','o','x'},
        {'x','x','o','x'},
        {'x','o','x','x'}};
    new Surrounded_Regions_130().solve(carr);
    Utils.print(carr);
  }


  final static char X = 'x';
  final static char O = 'o';
  static short[][] notSurroundedCells = null;

  public void solve(char[][] board)
  {
    if (board == null
        || board.length < 3
        || board[0].length < 3)
    {
      return;
    }

    notSurroundedCells = new short[board.length][board[0].length];
    for (int i = 0; i < board.length; i++)
    {
      markAsNotSurrounded(board, i, 0);
      markAsNotSurrounded(board, i, board[0].length-1);
    }
    for (int i = 0; i < board[0].length; i++)
    {
      markAsNotSurrounded(board, 0, i);
      markAsNotSurrounded(board, board.length-1, i);
    }

    // start from 1 and end with -1 because border cells cannot be surrounded
    for (int row = 1; row < board.length-1; row++)
    {
      for (int col = 1; col < board[0].length-1; col++)
      {
        if (board[row][col] == O && notSurroundedCells[row][col] != 1)
        {
          board[row][col] = X;
        }
      }
    }
  }

  public static void markAsNotSurrounded(char[][] board, int row, int col)
  {
    if (isOutOfBounds(board, row, col))
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
      markAsNotSurrounded(board, row-1, col);
      markAsNotSurrounded(board, row+1, col);
      markAsNotSurrounded(board, row, col-1);
      markAsNotSurrounded(board, row, col+1);
    }
  }

  public static boolean isOutOfBounds(char[][] board, int row, int col)
  {
    return row < 0 || row > board.length-1 || col < 0 || col > board[0].length-1;
  }
}

























