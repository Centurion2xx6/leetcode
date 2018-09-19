package java.leetcode;

public class ListNode {
  public int val;
  public ListNode next;
  public ListNode(int x) { val = x; }

  @Override public String toString()
  {
    StringBuilder sb = new StringBuilder();
    ListNode curNode = this;
    while (curNode != null)
    {
      sb.append(curNode.val);
      curNode = curNode.next;
    }
    return sb.toString();
  }
}
