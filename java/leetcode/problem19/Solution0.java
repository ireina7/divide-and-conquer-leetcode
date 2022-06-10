package leetcode.problem19;
import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution0 {
  int n = 0;
  ListNode dfs(ListNode node) {
    if(node == null) {
      return null;
    }
    ListNode xs = dfs(node.next);
    n -= 1;
    node.next = xs;
    return n == 0 ? xs : node;
  }
  public ListNode removeNthFromEnd(ListNode head, int n) {
    this.n = n;
    return dfs(head);
  }
}











