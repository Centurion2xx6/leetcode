package java.leetcode;

import leetcode.ListNode;

public class DataGenerator
{

  static ListNode[] getIntersectedLists()
  {
    ListNode l10 = new ListNode(0);
    ListNode l11 = new ListNode(1);
    ListNode l12 = new ListNode(2);
    ListNode l13 = new ListNode(3);
    ListNode l14 = new ListNode(4);
  
    ListNode l20 = new ListNode(0);
    ListNode l21 = new ListNode(1);
    ListNode l22 = new ListNode(2);
    ListNode l23 = new ListNode(3);
  
    l10.next = l11;
    l11.next = l12;
    l12.next = l13;
    l13.next = l14;
  
    l20.next = l21;
    l21.next = l22;
    l22.next = l23;
    l23.next = l13;
  
    return new ListNode[] {l10, l20};
  }

  static ListNode getNotCycledList()
  {
    ListNode l0 = new ListNode(0);
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
  
    l0.next = l1;
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    //l4.next = l0;
  
    return l0;
  }

  static ListNode getCycledList()
  {
    ListNode l0 = new ListNode(0);
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
  
    l0.next = l1;
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l0;
  
    return l0;
  }

  static int[] getArrayWithDuplicate()
  {
    return new int[]{1, 2, 3, 1, 1};
  }
}
