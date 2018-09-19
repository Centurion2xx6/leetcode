package leetcode;

import leetcode.utils.Utils;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main
{
  @SuppressWarnings("unused")
  public static void main(String[] args)
  {
    //TreeNode node = TreeNode.array2Tree(new Integer[]{3,1,5,0,2,4,6,null,null,null,3}, null, 0);
    //TreeNode node = TreeNode.array2Tree(new Integer[]{-2147483648,null,2147483647,-2147483648}, null, 0);
    //System.out.println(new Validate_Binary_Search_Tree_98().isValidBST(node));

    Utils.printBits(-5);
    Utils.printBits(10);
    Utils.printBits(5);

    System.out.println("start");
    if (true)
      return;

    System.out.println(new Power_of_Three_326().isPowerOfThree(3));
    System.out.println(new Power_of_Three_326().isPowerOfThree(1));
    System.out.println(new Power_of_Three_326().isPowerOfThree(9));
    System.out.println(new Power_of_Three_326().isPowerOfThree(27));
    System.out.println(new Power_of_Three_326().isPowerOfThree(59049));

    System.out.println(isSymmetric(getTreeFromArray(new Integer[]{1,2,2,null,3,null,3})));
    System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    Date curDate = new Date();
    System.out.println("1: "+largestPalindrome2(1));
    System.out.println("Time taken (ms): " + (new Date().getTime() - curDate.getTime()));
    curDate = new Date();
    System.out.println("2: "+largestPalindrome2(2));
    System.out.println("Time taken (ms): " + (new Date().getTime() - curDate.getTime()));
    curDate = new Date();
    System.out.println("3: "+largestPalindrome2(3));
    System.out.println("Time taken (ms): " + (new Date().getTime() - curDate.getTime()));
    curDate = new Date();
    System.out.println("4: "+largestPalindrome2(4));
    System.out.println("Time taken (ms): " + (new Date().getTime() - curDate.getTime()));
    curDate = new Date();
    System.out.println("5: "+largestPalindrome2(5));
    System.out.println("Time taken (ms): " + (new Date().getTime() - curDate.getTime()));
    curDate = new Date();
    System.out.println("6: "+largestPalindrome2(6));
    System.out.println("Time taken (ms): " + (new Date().getTime() - curDate.getTime()));
    curDate = new Date();
    System.out.println("7: "+largestPalindrome2(7));
    System.out.println("Time taken (ms): " + (new Date().getTime() - curDate.getTime()));
    curDate = new Date();
    System.out.println("8: "+largestPalindrome2(8));
    System.out.println("Time taken (ms): " + (new Date().getTime() - curDate.getTime()));
    curDate = new Date();
	    
	    /*System.out.println(lengthOfLongestSubstring("abcabcbb"));
    System.out.println(numSquares2(2752));
    System.out.println(numSquares2(12));*/
    //System.out.println(numSquares(7168));
    
    System.out.println(largestPalindrome(1));
    System.out.println(largestPalindrome(2));
    System.out.println(largestPalindrome(3));
    System.out.println(largestPalindrome(4));
    System.out.println(largestPalindrome(5));
    System.out.println(largestPalindrome(6));
    System.out.println(largestPalindrome(7));
    System.out.println(largestPalindrome(8));

    System.out.println(hammingDistance(1, 3));
    System.out.println(findDuplicate(DataGenerator.getArrayWithDuplicate()));
    System.out.println(detectCycle5(DataGenerator.getCycledList()).val);
    System.out.println(detectCycle(DataGenerator.getNotCycledList()));
    System.out.println(detectCycle4(DataGenerator.getCycledList()).val);
    ListNode[] lists = DataGenerator.getIntersectedLists();
    System.out.println(getListsIntersection3(lists[0], lists[1]).val);
    System.out.println(hasCycle(new ListNode(1)));
    System.out.println(hasCycle(DataGenerator.getNotCycledList()));
    System.out.println(hasCycle(DataGenerator.getCycledList()));

    //System.out.println(numSquares(43));
    System.out.println(numSquares(7168));

    int[] input = new int[] {1, 2, 3, 4, 5, 6};

    TreeNode ph = new TreeNode(0);
    addMiddleToTreeRecursive(ph, true, input);
    TreeNode res = ph.left;
    System.err.println(res.val);;
    //addIntoBst(input);

  }
  
  public static TreeNode getTreeFromArray(Integer[] treeArray)
  {
    if (treeArray == null || treeArray.length == 0)
    {
      return null;
    }
    TreeNode root = new TreeNode(treeArray[0]);
    addNodesToTreeRecursive(root, treeArray, 1, 2);
    return root;
  }
  public static void addNodesToTreeRecursive(TreeNode parent, Integer[] treeArray, int pairNum, int startingFrom)
  {
    if (treeArray.length < startingFrom*2-1)
    {
      return;
    }
    
    int leftIndex = startingFrom + (pairNum-1)*2 -1;
    int rightIndex = startingFrom + (pairNum-1)*2;
    if (treeArray[leftIndex] != null)
    {
      parent.left = new TreeNode(treeArray[leftIndex]);
      addNodesToTreeRecursive(parent.left, treeArray, pairNum*2-1, startingFrom*2);
    }
    if (treeArray[rightIndex] != null)
    {
      parent.right = new TreeNode(treeArray[rightIndex]);
      addNodesToTreeRecursive(parent.right, treeArray, pairNum*2, startingFrom*2);
    }
  }
  public static boolean isSymmetric(TreeNode root) 
  {
      return root == null || isSymetricRecursive(root.left, root.right);
  }
  
  private static boolean isSymetricRecursive(TreeNode nodeLeft, TreeNode nodeRight)
  {
      boolean thisIsSymetric = (nodeLeft == null && nodeRight == null) 
                                  || (nodeLeft != null && nodeRight != null && nodeLeft.val == nodeRight.val);
      return thisIsSymetric 
              && (nodeLeft == null ? true 
                          : (isSymetricRecursive(nodeLeft.left, nodeRight.right) && isSymetricRecursive(nodeLeft.right, nodeRight.left)));
  }
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) 
  {
    return 0;
  }
  
  public static SortedMap<Integer, SortedMap<Integer, SortedSet<Integer>>> possibleMultiplicationResultPairs = null;
  static
  {
    possibleMultiplicationResultPairs = getPossibleMultiplicationResultPairs();
  }
  
  public static int largestPalindrome2(int n)
  {
    SortedSet<Long> palindromes = new TreeSet<>();
    long result = 0;

    int maxNumber = (int) Math.pow(10, n) - 1; // n<=8

    // simple implementation: use array with pairs which multiplication equals to first palindrome digit
    // 9:
    //   1: 9
    //   3: 3
    //   7: 7
    //   9: 1
    // SortedMap<value_of_multiplication, SortedMap<last_digit_of_first_number, SortedSet<last_digit_of_second_number>>> 
    //SortedMap<Integer, SortedMap<Integer, SortedSet<Integer>>> possibleMultiplicationResultPairs = getPossibleMultiplicationResultPairs();    

    if (n <= 2)
    {
      int minNumber = (int) Math.pow(10, n - 1);
      for (int num1 = maxNumber; num1 >= minNumber; num1--)
      {
        if (!palindromes.isEmpty() &&
            1l * num1 * maxNumber < palindromes.last())
        {
          break;
        }

        for (int num2 = maxNumber; num2 >= num1; num2--)
        {

          result = 1l * num1 * num2;

          if (!palindromes.isEmpty() &&
              result < palindromes.last())
          {
            break;
          }

          if (isPalindrome(result))
          {
            if (palindromes.add(result))
            {
              System.out.println(">" + num1 + " X " + num2 + " = " + result);
            }
            break;
          }
        }
      }
    }
    else
    {  
      int maxSecondPart = (int) Math.pow(10, n-2) - 1; // max second part after first two digits. E.g. 999 for 99999    
      int num1 = maxNumber+1;
      for (int f1 = 99; f1 >= 10; f1--)
      {
        int ll1 = 10; // last digit of l1
        for (int l1 = maxSecondPart; l1 >= 0; l1--) //999 = last part in 'n' after 99 (first two digits) 
        {
          num1--;
          if (--ll1 < 0)
          {
            ll1 = 9;
          }
          if (!palindromes.isEmpty() &&
              1l * num1 * maxNumber < palindromes.last())
          {
            f1 = -1; // total maximum reached -> exit root loop
            break;
          }
          
          int num2 = maxNumber+1;
          boolean maxReachedForNum1 = false;
          for (int f2 = 99; f2 >= f1; f2--)
          { 
            if (maxReachedForNum1)
            {
              break;
            }
            int firstPalindromeDigit = getFirstDigit(f1 * f2); // calculate palindrome first digit
            Set<Integer> possiblePair = possibleMultiplicationResultPairs.get(firstPalindromeDigit).get(ll1);// get set of possible pairs for current last digit of l1
            
            int ll2 = 10;
            for (int l2 = maxSecondPart; l2 >= l1; l2--)
            {
              num2--;          
              if (--ll2 < 0)
              {
                ll2 = 9;
              }
              if (possiblePair == null || !possiblePair.contains(ll2))
              {
                continue;
              }
              
              result = 1l * num1 * num2;
              
              if (!palindromes.isEmpty() &&
                  result < palindromes.last())
              {
                maxReachedForNum1 = true;
                break;
              }
              
              if (isPalindrome(result))
              {
                if (palindromes.add(result))
                {
                  System.out.println(">" + num1 + " X " + num2 +" = "+result);
                }
                break;
              }
            }
          }
        }        
      }
    }
        
    System.out.println("Max palindrome: " + (!palindromes.isEmpty() ? palindromes.last() : 0));
    return (int) ((!palindromes.isEmpty() ? palindromes.last() : 0) % 1337);
  }
  
  public static SortedMap<Integer, SortedMap<Integer, SortedSet<Integer>>> getPossibleMultiplicationResultPairs()
  {
    SortedMap<Integer, SortedMap<Integer, SortedSet<Integer>>> correctPairs = new TreeMap<Integer, SortedMap<Integer, SortedSet<Integer>>>();
    for (int target=0; target<=9; target++)
    {
      SortedMap<Integer, SortedSet<Integer>> pairs = correctPairs.get(target);
      if (pairs == null)
      {
        pairs = new TreeMap<Integer, SortedSet<Integer>>();
      }
      for (int n1=0; n1<=9; n1++)
      {
        //pairs = new TreeMap<Integer, SortedSet<Integer>>();
        for (int n2=0; n2<=9; n2++)
        {
          if (getDigitAtPos(n1*n2, 1) == target)
          {
            SortedSet<Integer> secondDigitValues = pairs.get(n1);
            if (secondDigitValues == null)
            {
              secondDigitValues = new TreeSet<Integer>();
            }
            secondDigitValues.add(n2);
            pairs.put(n1, secondDigitValues);
          }
        }
      }
      correctPairs.put(target, pairs);
    }
    return correctPairs;    
  }
  
  public static int largestPalindrome(int n)
  {
    SortedSet<Long> palindromes = new TreeSet<>();
    long result = 0;

    int maxNumber = (int) Math.pow(10, n) - 1; // n<=8
    int minNumber = (int) Math.pow(10, n - 1);

    int sectionsNumber = Math.max(maxNumber - minNumber, 1);
    int rangePart = (maxNumber - minNumber) / sectionsNumber;
    int curSectionNumber = 1;
    while (curSectionNumber <= sectionsNumber)
    {

      int top = rangePart * (sectionsNumber - curSectionNumber + 1) + minNumber;
      int bottom = rangePart * (sectionsNumber - curSectionNumber) + minNumber;
      for (int num1 = top; num1 >= bottom; num1--)
      {
        if (!palindromes.isEmpty() &&
            1L * num1 * maxNumber < palindromes.last())
        {
          break;
        }

        for (int num2 = maxNumber; num2 >= bottom; num2--)
        {
          result = 1L * num1 * num2;

          if (!palindromes.isEmpty() &&
              result < palindromes.last())
          {
            break;
          }

          if (isPalindrome(result) && !palindromes.contains(result))
          {
            System.out.println(">" + num1 + " X " + num2 +" = "+result);
            palindromes.add(result);
            break;
          }
        }
      }

      curSectionNumber++;
    }
    
    System.out.println("Max palindrome: " + (!palindromes.isEmpty() ? palindromes.last() : 0));
    return (int) ((!palindromes.isEmpty() ? palindromes.last() : 0) % 1337);
  }
  public static int getFirstDigit(long number)
  {
    while (number > 9)
    {
      number /= 10;
    }
    return (int) number;
  }
  public static boolean isPalindrome(long number)
  {
    String numberStr = String.valueOf(number);
    for (int rightPos = 1; rightPos <= (int) Math.ceil(numberStr.length() / 2); rightPos++)
    {
      if (numberStr.charAt(rightPos - 1) != numberStr.charAt(numberStr.length() - rightPos))
      {
        return false;
      }
    }
    return true;
  }

  public static boolean isPalindrome2(long number)
  {
    boolean isPalindrome = true;

    int resultPower = 1;
    long base = 10;
    while (number / base >= 1)
    {
      resultPower++;
      base *= 10;
    }
    int middlePosition = (int) Math.ceil(resultPower / 2);

    if (number > 9)
    {
      for (int rightPos = 1; rightPos <= middlePosition; rightPos++)
      {
        if (getDigitAtPos(number, rightPos) != getDigitAtPos(number, resultPower - rightPos + 1))
        {
          isPalindrome = false;
          break;
        }
      }
    }
    return isPalindrome;
  }
  /**
   * Position is counted from right, starting from 1.
   * @return
   */
  public static int getNumberPart(long number, int startPosition, int endPosition)
  {
    int power = (int) Math.pow(10, endPosition - startPosition + 1);
    return (int) ((number / Math.pow(10, startPosition - 1)) % power);
  }
  
  /**
   * Position is counted from right, starting from 1.
   * @return
   */
  public static int getDigitAtPos(long number, int position)
  {
    return (int) ((number / Math.pow(10, position - 1)) % 10);
  }

  public static int hammingDistance(int x, int y)
  {
    int modSum = x ^ y;
    int result = 0;
    while (modSum != 0)
    {
      result += modSum & 1;
      modSum = modSum >> 1;
    }
    return result;
  }

  public static int findDuplicate3(int[] nums)
  {
    byte[] existingNums = new byte[nums.length - 1];
    for (int i = 0; i < nums.length; i++)
    {
      if (existingNums[nums[i]] == 1)
      {
        return nums[i];
      }
      else
      {
        existingNums[nums[i]] = 1;
      }
    }

    return 0;
  }

  public static int findDuplicate(int[] nums)
  {
    for (int i = 0; i < nums.length - 1; i++)
    {
      for (int j = i + 1; j < nums.length; j++)
      {
        if (nums[i] == nums[j])
        {
          return nums[i];
        }
      }
    }

    return 0;
  }

  public static int findDuplicate2(int[] nums)
  {
    HashSet<Integer> existingNums = new HashSet<>();

    for (int i = 0; i < nums.length; i++)
    {
      if (!existingNums.add(nums[i]))
      {
        return nums[i];
      }
    }
    return 0;
  }

  public static ListNode detectCycle5(ListNode head)
  {
    if (head == null)
      return null;

    ListNode walker = head;
    ListNode runner = head;

    do
    {
      if (runner == null || runner.next == null)
      {
        return null;
      }
      walker = walker.next;
      runner = runner.next.next;

    }
    while (walker != runner);

    // when runner overtakes a walker: 
    // walker went X nodes from beginning.
    // runner went 2*X nodes: X nodes from beginning to this position, Y nodes until loop after X position, 
    //                                                     and Z nodes after loop on the line head-Xpos.
    // this can be shown as follows:
    // walker:       [0.........X]
    // runner: 0->X->Y->Z
    // runner: 1stX: [0.........X][....Y]
    // runner: 2ndX:      [.....Z]

    // since Y+Z=X, Z=X-Y: we can go from X and from 0pos. at the same time: this will make [.....Z] range mutual for both walkers.

    ListNode walker1 = head;
    ListNode walker2 = walker;
    while (walker1 != walker2)
    {
      walker1 = walker1.next;
      walker2 = walker2.next;
    }
    return walker1;
  }

  public static ListNode detectCycle4(ListNode head)
  {
    // node to check for equality with current node
    ListNode checkNode = null;
    // count of nodes from start to check node 
    int checkNodeIndex = 0;

    // range to update check node
    int currentRange = 1;
    // current index counter
    int counter = 0;
    // count of nodes from start to second time when we found a check node
    int secondCountToCheckNode = 0;

    ListNode curNode = head;
    while (curNode != null)
    {
      counter++;
      if (curNode == checkNode) // we found a check node second time (1: remembered it; 2: found it in a loop)
      {
        secondCountToCheckNode = counter;
        break; // cycle found 
      }
      if (counter == currentRange)
      {
        currentRange *= 2;
        checkNode = curNode;
        checkNodeIndex = counter;
      }

      curNode = curNode.next;
    }

    // reached the end of list => no cycle
    if (curNode == null)
      return null;

    // the length of a loop
    int loopLength = secondCountToCheckNode - checkNodeIndex;

    curNode = head;
    while (!isInRange(curNode, checkNode, loopLength))
    {
      curNode = curNode.next;
    }
    return curNode;
  }

  public static ListNode detectCycle(ListNode head)
  {
    // node to check for equality with current node
    ListNode checkNode = null;
    // count of nodes from start to check node 
    int checkNodeIndex = 0;

    // range to update check node
    int currentRange = 1;
    // current index counter
    int counter = 0;
    // count of nodes from start to second time when we found a check node
    int secondCountToCheckNode = 0;

    ListNode curNode = head;
    while (curNode != null)
    {
      counter++;
      if (curNode == checkNode) // we found a check node second time (1: remembered it; 2: found it in a loop)
      {
        secondCountToCheckNode = counter;
        break; // cycle found 
      }
      if (counter == currentRange)
      {
        currentRange *= 2;
        checkNode = curNode;
        checkNodeIndex = counter;
      }

      curNode = curNode.next;
    }

    // reached the end of list => no cycle
    if (curNode == null)
      return null;

    // the length of a loop
    int loopLength = secondCountToCheckNode - checkNodeIndex;

    // recalculate a check index, since a check node could be found via second or a later cycle iteration
    curNode = head;
    checkNodeIndex = 0;
    while (curNode != checkNode)
    {
      checkNodeIndex++;
      curNode = curNode.next;
    }
    return findLoopStartNodeRecursive(head, checkNodeIndex, checkNode, loopLength);
  }

  /**
   * Returns true if searchNode is in range of startNode + rangeLength next nodes. E.g. if rangeLength=1 then method checks a start node and one next node.
   * @param searchNode
   * @param startNode
   * @param rangeLength
   * @return  
   */
  private static boolean isInRange(ListNode searchNode, ListNode startNode, int rangeLength)
  {
    for (int i = 0; i < rangeLength; i++)
    {
      if (searchNode == startNode)
      {
        return true;
      }
      else
      {
        startNode = startNode.next;
      }
    }
    return false;
  }

  /**
   * Finds a node which is in a list loop, while closest previous node is not in a loop. Loop: is node 'nodeInLoop' with 'loopLength' next nodes.
   * @param startNode node to start a search from 
   * @param rangeLength range of nodes next to start node to check
   * @param nodeInLoop a node which is contained in a loop
   * @param loopLength length of a loop
   * @return
   */
  private static ListNode findLoopStartNodeRecursive(ListNode startNode, int rangeLength, ListNode nodeInLoop, int loopLength)
  {
    if (rangeLength == 0)
    {
      boolean startNodeInRange = isInRange(startNode, nodeInLoop, loopLength);
      if (startNodeInRange)
      {
        return startNode;
      }
      else
      {
        return null;
      }
    }

    if (rangeLength == 1)
    {
      boolean startNodeInRange = isInRange(startNode, nodeInLoop, loopLength);
      if (startNodeInRange)
      {
        return startNode;
      }

      boolean nextNodeInRange = isInRange(startNode.next, nodeInLoop, loopLength);
      if (!startNodeInRange && nextNodeInRange)
      {
        return startNode.next;
      }
      else
      {
        return null;
      }
    }

    int firstRangeHalf = rangeLength / 2;
    int secondRangeHalf = rangeLength - firstRangeHalf;

    ListNode middleNode = startNode;
    for (int i = 0; i < firstRangeHalf; i++)
    {
      middleNode = middleNode.next;
    }

    if (isInRange(middleNode, nodeInLoop, loopLength))
    {
      return findLoopStartNodeRecursive(startNode, firstRangeHalf, nodeInLoop, loopLength);
    }
    else
    {
      return findLoopStartNodeRecursive(middleNode.next, secondRangeHalf, nodeInLoop, loopLength);
    }
  }

  public static ListNode detectCycle3(ListNode head)
  {
    // node to check for equality with current node
    ListNode checkNode = null;
    // count of nodes from start to check node 
    int checkNodeIndex = 0;

    // range to update check node
    int currentRange = 1;
    // current index counter
    int counter = 0;
    // count of nodes from start to second time when we found a check node
    int secondCountToCheckNode = 0;

    ListNode curNode = head;
    while (curNode != null)
    {
      counter++;
      if (curNode == checkNode) // we found a check node second time (1: remembered it; 2: found it in a loop)
      {
        secondCountToCheckNode = counter;
        break; // cycle found 
      }
      if (counter == currentRange)
      {
        currentRange *= 2;
        checkNode = curNode;
        checkNodeIndex = counter;
      }

      curNode = curNode.next;
    }

    // reached the end of list => no cycle
    if (curNode == null)
      return null;

    // the length of a loop
    int loopLength = secondCountToCheckNode - checkNodeIndex;

    HashSet<ListNode> cycleNodes = new HashSet<>();
    ListNode tempNode = checkNode;
    for (int i = 0; i < loopLength; i++)
    {
      cycleNodes.add(tempNode);
      tempNode = tempNode.next;
    }

    tempNode = head;
    while (!cycleNodes.contains(tempNode))
    {
      tempNode = tempNode.next;
    }
    return tempNode;
  }

  public ListNode detectCycle2(ListNode head)
  {
    HashSet<ListNode> nodesSet = new HashSet<>();
    while (head != null)
    {
      if (!nodesSet.add(head))
        return head;

      head = head.next;
    }

    return null;
  }

  public static ListNode getListsIntersection3(ListNode headA, ListNode headB)
  {
    if (headA == null || headB == null)
    {
      return null;
    }

    ListNode tempNode = headA;
    ListNode aLast = null;
    int aLength = 0;
    while (tempNode != null)
    {
      aLength++;
      aLast = tempNode;
      tempNode = tempNode.next;
    }
    tempNode = headB;
    ListNode bLast = null;
    int bLength = 0;
    while (tempNode != null)
    {
      bLength++;
      bLast = tempNode;
      tempNode = tempNode.next;
    }

    if (aLast != bLast)
    {
      return null;
    }

    while (aLength != bLength)
    {
      if (aLength > bLength)
      {
        headA = headA.next;
        aLength--;
      }
      else
      {
        headB = headB.next;
        bLength--;
      }
    }

    while (headA != null)
    {
      if (headA == headB)
      {
        return headA;
      }
      headB = headB.next;
      headA = headA.next;
    }

    return null;
  }

  static int firstListShiftAmount = 0;

  public static ListNode getListsIntersection(ListNode headA, ListNode headB)
  {
    countFirstListShiftRecursive(headA, headB);
    if (firstListShiftAmount > 0)
    {
      while (firstListShiftAmount > 0) // first list has 'firstListShiftAmount' less elements 
      {
        headB = headB.next;
        firstListShiftAmount--;
      }
    }
    else
    {
      while (firstListShiftAmount < 0) // second list has 'firstListShiftAmount' less elements 
      {
        headA = headA.next;
        firstListShiftAmount++;
      }
    }

    while (headA != null)
    {
      if (headA == headB)
      {
        return headA;
      }
      headB = headB.next;
      headA = headA.next;
    }

    return null;
  }

  public static void countFirstListShiftRecursive(ListNode l1, ListNode l2)
  {
    if (l1 == l2)
      return;

    if (l1 == null)
    {
      firstListShiftAmount++;
    }
    else if (l2 == null)
    {
      firstListShiftAmount--;
    }

    countFirstListShiftRecursive(l1 != null ? l1.next : null,
        l2 != null ? l2.next : null);
  }

  public static ListNode getListsIntersection1(ListNode l1, ListNode l2)
  {
    HashSet<ListNode> allNodes = new HashSet<>();
    while (l1 != null)
    {
      allNodes.add(l1);
      l1 = l1.next;
    }

    while (l2 != null)
    {
      if (allNodes.contains(l2))
      {
        return l2;
      }
      l2 = l2.next;
    }

    return null;
  }

  public static boolean hasCycle(ListNode head)
  {
    int count = 0;
    int nextSet = 1;

    ListNode check = head;
    ListNode curNode = head;
    while (++count < Integer.MAX_VALUE)
    {
      if (curNode == null)
        return false;

      curNode = curNode.next;

      if (curNode == check)
        return true;

      if (count == nextSet)
      {
        check = curNode;
        nextSet *= 2;
      }
    }

    return false;
  }

  public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
  {
    int area1 = (C - A) * (D - B);
    int area2 = (G - E) * (H - F);
    int res = area1 + area2;

    if (H > B && F < D &&
        G > A && E < C)  // there is an intersection
    {
      int yInt = Math.max(D - F - Math.max(B - F, 0) - Math.max(D - H, 0), 0);
      int xInt = Math.max(C - E - Math.max(A - E, 0) - Math.max(C - G, 0), 0);
      res -= xInt * yInt;
    }

    return res;
  }

  //private static SortedMap<Integer, Integer> cache = new TreeMap<>();
  public static int numSquares(int n)
  {
    /*Integer cachedResult = cache.get(n);
    if (cachedResult != null)
    {
      return cachedResult;
    }*/
    
    int maxPossibleNum = (int) Math.sqrt(n);
    int[] squares = new int[maxPossibleNum];
    for (int i = 0; i < squares.length; i++)
    {
      squares[i] = (i + 1) * (i + 1);
    }

    SortedSet<Integer> result = new TreeSet<>();
    for (int i = squares.length - 1; i >= 0; i--)
    {
      checkSumRecursive(squares, i, 0, n, result);
    }
    int resultInteger = !result.isEmpty() ? result.first() : 0;
    //cache.put(n, resultInteger);
    return resultInteger;
  }

  private static boolean checkSumRecursive(int[] squares, int pivot, int count, int sum, SortedSet<Integer> result)
  {
    if (pivot < 0)
    {
      return true;
    }/*
    Integer cachedResult = cache.get(sum);
    if (cachedResult != null)
    {
      result.add(count + cachedResult);
      return false;
    }*/

    int square = squares[pivot];

    pivot--;
    for (int i = (sum / square); i >= 0; i--)
    {
      int curCount = count + i;
      if (!result.isEmpty() && (count + sum / square) >= result.first())
      {
        return false;
      }

      int toSum = sum - square * i;
      if (toSum == 0)
      {
        result.add(curCount);
        return true;
        //continue;
      }
      else if (!checkSumRecursive(squares, pivot, curCount, toSum, result))
      {
        break;
      }
    }
    return true;
  }
  
  
  public static int numSquares2(int n)
  {    
    result = new TreeSet<>();
    
    int maxPossibleNum = (int) Math.sqrt(n);
    squares = new int[maxPossibleNum];
    for (int i = 0; i < squares.length; i++)
    {
      squares[i] = (i + 1) * (i + 1);
    }

    for (int i = squares.length - 1; i >= 0; i--)
    {
      checkSumRecursive(i, 0, n);
    }
    int resultInteger = !result.isEmpty() ? result.first() : 0;

    return resultInteger;
  }
  static SortedSet<Integer> result;
  static int[] squares;
  private static boolean checkSumRecursive(int pivot, int count, int sum)
  {
    if (pivot < 0)
    {
      return true;
    }

    int square = squares[pivot];

    pivot--;
    for (int i = (sum / square); i >= 0; i--)
    {
      int curCount = count + i;
      if (!result.isEmpty() && curCount >= result.first())
      {
        return false;
      }

      int toSum = sum - square * i;
      if (toSum == 0)
      {
        result.add(curCount);
        return true;
        //continue;
      }
      else if (!checkSumRecursive(pivot, curCount, toSum))
      {
        break;
      }
    }
    return true;
  }
  
  
  public static void printTreeRecursive(TreeNode node, int level)
  {
    level++;
    //for (int )
  }

  private static void addMiddleToTreeRecursive(TreeNode node, boolean isLeft, int[] arr)
  {
    if (arr.length == 0)
      return;

    int middleInd = arr.length / 2;
    TreeNode newNode = new TreeNode(arr[middleInd]);

    if (isLeft)
      node.left = newNode;
    else
      node.right = newNode;

    if (middleInd > 0)
    {
      addMiddleToTreeRecursive(newNode, true, Arrays.copyOfRange(arr, 0, middleInd));
    }
    if (arr.length - middleInd > 1)
    {
      addMiddleToTreeRecursive(newNode, false, Arrays.copyOfRange(arr, middleInd + 1, arr.length));
    }
  }

  public static TreeNode addIntoBst(int[] input)
  {
    if (input.length == 0)
      return null;

    TreeNode root = new TreeNode(input[0]);

    for (int i = 1; i < input.length; i++)
    {
      addNodeToBstRecursive(root, new TreeNode(input[i]));
      if (!isBstBalanced(root))
      {
        balanceBst(root);
      }
    }
    return root;
  }

  public static void balanceBst(TreeNode root)
  {

  }

  public static void addNodeToBstRecursive(TreeNode curNode, TreeNode newNode)
  {/*
   boolean toLeft = curNode.val > newNode.val;
   if (toLeft)
   {
   if (curNode.left == null || curNode.left.val < newNode.val)  // TODO: rebalance if < and we put it here until we find a ..
   {
   newNode.left = curNode.left;
   curNode.left = newNode;
   }
   else
   {
   addNodeToBstRecursive(curNode.left, newNode);
   }
   }
   else 
   {
   if (curNode.right == null || curNode.right.val > newNode.val)  // TODO: rebalance if > and we put it here until we find a ..
   {
   newNode.right = curNode.right;
   curNode.right = newNode;
   }
   else
   {
   addNodeToBstRecursive(curNode.right, newNode);
   }
   }*/
    boolean toLeft = curNode.val > newNode.val;
    if (toLeft && curNode.left == null)
    {
      newNode.left = curNode.left;
      curNode.left = newNode;
      // rebalance after insert
      return;
    }
    else if (!toLeft && curNode.right == null)
    {
      newNode.right = curNode.right;
      curNode.right = newNode;
      return;
    }

    addNodeToBstRecursive(curNode.left, newNode);
  }

  public static boolean isBstBalanced(TreeNode root)
  {
    return getBstMaxDepthRecursive(root, 0) - getBstMinDepthRecursive(root, 0) <= 1;
  }

  public static int getBstMaxDepthRecursive(TreeNode node, int curDepth)
  {
    curDepth++;
    int left = node.left != null ? getBstMaxDepthRecursive(node.left, curDepth) : curDepth;
    int right = node.right != null ? getBstMaxDepthRecursive(node.right, curDepth) : curDepth;
    return Math.max(left, right);
  }

  public static int getBstMinDepthRecursive(TreeNode node, int curDepth)
  {
    curDepth++;
    int left = node.left != null ? getBstMinDepthRecursive(node.left, curDepth) : curDepth;
    int right = node.right != null ? getBstMinDepthRecursive(node.right, curDepth) : curDepth;
    return Math.min(left, right);
  }

  public static void printBites(int num)
  {
    for (int i=0; i<32; i++)
    {
      System.out.print((num & 0b10000000000000000000000000000000) == 0 ? "0" : "1");
      num = num << 1;
    }
    System.out.println();
  }
  public static int hammingWeight(int n) 
  {
      short res = 0;
      while(n != 0)
      {
          res += n & 1;
          n = n >>> 1;
      }
      return res;
  }

  public static int[] twoSum(int[] nums, int target)
  {
    HashMap<Integer, Integer> elementIndexes = new HashMap<>();
    for (int i = 0; i < nums.length; i++)
    {
      int diff = target - nums[i];
      Integer diffIndex = elementIndexes.get(diff);
      if (diffIndex != null)
      {
        return new int[] {diffIndex, i};
      }
      else
      {
        elementIndexes.put(nums[i], i);
      }
    }
    return null;
  }
  
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0)
      return null;
    
    TreeNode head = addMiddleToTreeRecursive2(nums, 0, nums.length-1);
    return head;
  }
  
  private static TreeNode addMiddleToTreeRecursive2(int[] arr, int startIndex, int endIndex)
  {
      if (endIndex - startIndex < 0)
        return null;
      
      int middleInd = (endIndex + startIndex)/2;
      TreeNode node = new TreeNode(arr[middleInd]);
            
      node.left = addMiddleToTreeRecursive2(arr, startIndex, middleInd-1);
      node.right = addMiddleToTreeRecursive2(arr, middleInd+1, endIndex);
      
      return node;
  }
  
  public static int lengthOfLongestSubstring(String s) 
  {
    int maxLength = 0;
    int curLength = 0;
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<s.length(); i++)
    {
      int savedIndex = sb.indexOf(""+s.charAt(i));
      if (savedIndex != -1)
      { 
        curLength = sb.length();
        if (maxLength < curLength)
        {
          maxLength = curLength;
        }
        sb.delete(0, savedIndex+1);
      }
      sb.append(""+s.charAt(i));
    }
    return maxLength;
  }
}
