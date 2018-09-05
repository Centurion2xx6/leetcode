package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Count_Primes_204
{
  public Count_Primes_204(){}

  @Test
  public void test_3()
  {
    Assert.assertEquals(countPrimes(3), 1);
  }

  @Test
  public void test_499979()
  {
    Assert.assertEquals(countPrimes(499979), 41537);
  }

  private Set<Integer> primes = new HashSet<>();
  public int countPrimes(int n)
  {
    if (n < 3)
    {
      return 0;
    }
    int num = 1; // first prime = 2

    for (int i = 3; i < n; i+=2)
    {
      if (isPrime(i))
      {
        primes.add(i);
        num++;
      }
    }

    return num;
  }

  private boolean isPrime(int n)
  {
    for (int prime : primes)
    {
      if (n % prime == 0)
      {
        return false;
      }
    }
    return true;
  }
}
