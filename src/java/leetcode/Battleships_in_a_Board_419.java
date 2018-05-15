package leetcode;

/**
 * @author goloschy
 */

public class Battleships_in_a_Board_419
{
  public static void main(String[] args)
  {
    new Battleships_in_a_Board_419().countBattleships(new char[][]{new char[]{'.'}, new char[]{'.'}, new char[]{'X'}});

  }

  public int countBattleships(char[][] board)
  {
    if (board.length == 0
        || board[0].length == 0)
    {
      return 0;
    }

    int count = 0;
    for (int i=0; i<board.length; i++)
    {
      for (int j=0; j<board[i].length; j++)
      {
        if (isX(board[i][j]))
        {
          if ((i==0 || !isX(board[i-1][j]))  // left
            && (j==0 || !isX(board[i][j-1]))) // top
          {
            count++;
          }
        }
      }
    }
    return count;
  }

  public boolean isX(char c)
  {
    return c == 'X';
  }
}
