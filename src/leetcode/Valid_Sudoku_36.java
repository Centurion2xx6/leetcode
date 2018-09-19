package leetcode;

/**
 * Created by Alex on 17.05.2017.
 */
public class Valid_Sudoku_36 {
    public static void main(String[] args)
    {
        char[][] ca = parseInput(new String[]{"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"});
        System.out.println(isValidSudoku(ca));

        char[][] ca2 = parseInput(new String[]{".87654321","2........","3........","4........","5........","6........","7........","8........","9........"});
        System.out.println(isValidSudoku(ca2));
    }

    private static char[][] parseInput(String[] sa)
    {
        char[][] ca = new char[9][9];
        for (int i=0; i<=8; i++)
        {
            String s = sa[i];
            System.out.println();

            for (int j = 0; j <= 8; j++)
            {
                char c = s.charAt(j);
                ca[i][j] = c;
                System.out.print(c);
            }
        }
        return ca;
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i=0; i<=8; i++)
        {
            short[] s = new short[9];

            for (int j=0; j<=8; j++)
            {
                char c = board[i][j];
                if (c != '.')
                {
                    int num = Character.getNumericValue(c);
                    if (num < 1 || num > 9)
                    {
                        return false;
                    }
                    if (s[num-1] == 1)
                    {
                        return false;
                    }

                    s[num-1] = 1;
                }
            }
        }

        for (int i=0; i<=8; i++)
        {
            short[] s = new short[9];

            for (int j=0; j<=8; j++)
            {
                char c = board[j][i];
                if (c != '.')
                {
                    int num = Character.getNumericValue(c);
                    if (num < 1 || num > 9)
                    {
                        return false;
                    }
                    if (s[num-1] == 1)
                    {
                        return false;
                    }

                    s[num-1] = 1;
                }
            }
        }


        for (int x=0; x<=6; x = x+3)
        {
            for (int y = 0; y <= 6; y = y + 3)
            {
                short[] s = new short[9];

                for (int i = 0; i <= 2; i++)
                {
                    for (int j = 0; j <= 2; j++)
                    {
                        char c = board[i + x][j + y];
                        if (c != '.')
                        {
                            int num = Character.getNumericValue(c);
                            if (num < 1 || num > 9)
                            {
                                return false;
                            }
                            if (s[num-1] == 1)
                            {
                                return false;
                            }

                            s[num-1] = 1;
                        }
                    }
                }
            }
        }
        return true;
    }
}
