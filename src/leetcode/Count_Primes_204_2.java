package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Count_Primes_204_2
{
  public Count_Primes_204_2(){}

  @Test
  public void test_3()
  {
    Assert.assertEquals(countPrimes(3), 1);
  }
  @Test
  public void test_5()
  {
    Assert.assertEquals(countPrimes(5), 2);
  }

  @Test
  public void test_499979()
  {
    Assert.assertEquals(countPrimes(499979), 41537);
  }

  public int countPrimes(int n)
  {
    if (n <= 2)
    {
      return 0;
    }
    // 0 = prime; 1 = not prime
    byte[] notPrimes = new byte[n-1];
    notPrimes[0] = 1; // index = 0; number = 1 (number = ind+1)
    for (int ind = 1; ind < notPrimes.length; ind++)
    {
      if (notPrimes[ind] == 0)
      {
        setOneToEveryNElem(ind+1, notPrimes);
      }
    }
    return getZeroesCount(notPrimes);
  }

  private int getZeroesCount(byte[] arr)
  {
    int sum = 0;
    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i] == 0)
      {
        sum++;
      }
    }
    return sum;
  }

  /**
   * Set to zero every n elem, starting from elem n+n-1
   */
  private void setOneToEveryNElem(int n, byte[] arr)
  {
    for (int i = n+n-1; i < arr.length; i += n)
    {
      arr[i] = 1;
    }
  }
}
