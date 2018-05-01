package leetcode;

public class Sort_List_148
{
  public static void main(String[] args)
  {

    System.out.println(sortList(null));
  }
  public static ListNode sortList(ListNode head)
  {
    if (head == null)
    {
      return null;
    }
    long nodesCount = countNodes(head);
    return null;
  }

  private static long countNodes(ListNode head)
  {
    long count = 0;
    ListNode curNode = head;
    while (curNode != null)
    {
      count++;
      curNode = curNode.next;
    }
    return count;
  }
}
