package leetcode;

public class Longest_Palindromic_Substring_5
{
  public static void main(String[] args)
  {
    //System.out.println(": " + new Longest_Palindromic_Substring_5().longestPalindrome("iopsajhffgvrnyitusobwcxgwlwniqchfnssqttdrnqqcsrigjsxkzcmuoiyxzerakhmexuyeuhjfobrmkoqdljrlojjjysfdslyvckxhuleagmxnzvikfitmkfhevfesnwltekstsueefbrddxrmxokpaxsenwlgytdaexgfwtneurhxvjvpsliepgvspdchmhggybwupiqaqlhjjrildjuewkdxbcpsbjtsevkppvgilrlspejqvzpfeorjmrbdppovvpzxcytscycgwsbnmspihzldjdgilnrlmhaswqaqbecmaocesnpqaotamwofyyfsbmxidowusogmylhlhxftnrmhtnnljjhhcfvywsqimqxqobfsageysonuoagmmviozeouutsiecitrmkypwknorjjiaasxfhsftypspwhvqovmwkjuehujofiabznpipidhfxpoustquzyfurkcgmioxacleqdxgrxbldcuxzgbcazgfismcgmgtjuwchymkzoiqhzaqrtiykdkydgvuaqkllbsactntexcybbjaxlfhyvbxieelstduqzfkoceqzgncvexklahxjnvtyqcjtbfanzgpdmucjlqpiolklmjxnscjcyiybdkgitxnuvtmoypcdldrvalxcxalpwumfx"));
    System.out.println(": " + new Longest_Palindromic_Substring_5().longestPalindrome("babab"));
  }
  public String longestPalindrome(String s)
  {
    if (s == null)
    {
      return null;
    }
    else if (s.equals(""))
    {
      return s;
    }
    int longestPalindromeLength = 1;
    String longestPalindrome = s.substring(0, 1);
    for (int i = 0; i < s.length()-1; i++)
    {
      for (int j = s.length()-1; j > i; j--)
      {
        if ((j - i) < longestPalindromeLength)
        {
          break;
        }
        boolean isPal = true;
        int si = i;
        int sj = j;
        while (si < sj)
        {
          if (s.charAt(si) != s.charAt(sj))
          {
            isPal = false;
            break;
          }
          si++;
          sj--;
        }
        if (isPal)
        {
          longestPalindromeLength = j - i;
          longestPalindrome = s.substring(i, j+1);
        }
      }
    }
    return longestPalindrome;
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
