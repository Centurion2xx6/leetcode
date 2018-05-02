package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber
{
  private static int primeNumberCursor;
  private static List<Integer> primeNumbers = new ArrayList<>();
  public static void main(String[] args)
  {
    //System.out.println(isUgly(2));
    System.out.println(isUgly(214797179));
  }
  
  static
  {
    primeNumbers.add(2);
    primeNumbers.add(3);
    primeNumbers.add(5);
  }
  public static boolean isUgly(int num) 
  {
    if (num == 1)
    {
      return true;
    }
    if (num <= 0)
    {
      return false;
    }
    
    // indexes 0-2 are ugly
    primeNumberCursor = 2;
    int primeNumber;
    while ((primeNumber = getNextPrimeNumber()) <= num)
    {
      if (num%primeNumber == 0)
      {
        return false;
      }
    }
    return true;
  }

  private static Integer getNextPrimeNumber()
  {
    primeNumberCursor++;
    if (primeNumbers.size() > primeNumberCursor)
    {
      return primeNumbers.get(primeNumberCursor);
    }
    else
    {
      int curCheckNumber = primeNumbers.get(primeNumbers.size()-1);
      
      while (curCheckNumber++ < Integer.MAX_VALUE)
      {
        for (Integer primeNumber : primeNumbers)
        {
          if (curCheckNumber%primeNumber == 0)
          {
            primeNumbers.add(curCheckNumber);
            return curCheckNumber;
          }
        }
      }
      return null;
    }
  }
}
