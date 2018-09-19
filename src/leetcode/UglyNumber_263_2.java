package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber_263_2
{
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
    
    fillPrimeFactors(num);
    
    // indexes 0-2 are ugly
    for (int i=3; i<primeNumbers.size(); i++)
    {
      if (num%primeNumbers.get(i) == 0)
      {
        return false;
      }
    }
    return true;
  }

  private static void fillPrimeFactors(int num)
  {
    int maxCheckedFactor = primeNumbers.get(primeNumbers.size()-1);
    while (maxCheckedFactor < num)
    {
      maxCheckedFactor++;
      boolean isPrimeNumber = true; 
      for (Integer primeNumber : primeNumbers)
      {
        if (maxCheckedFactor%primeNumber == 0)
        {
          isPrimeNumber = false; 
          break;
        }
      }
      if (isPrimeNumber)
      {
        primeNumbers.add(maxCheckedFactor);
      }
    }    
  }
}
