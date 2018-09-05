package main.leetcode;

public class Prime_Palindrome_866
{
  public Prime_Palindrome_866() { }

  public int primePalindrome(int N)
  {

  }

  private static boolean isPrimeNumber(int n)
  {
    if (n > 10)
  }

  private static byte[] getNumberDigits(int n)
  {

  }

  private static boolean isPalindrome(String s)
  {
    int i = 0;
    int j = s.length()-1;
    if (j == 0)
    {
      // one char string
      return true;
    }
    while (i < j)
    {
      if (s.charAt(i) != s.charAt(j))
      {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
