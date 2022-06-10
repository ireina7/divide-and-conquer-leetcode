package leetcode.problem21;
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
  public ListNode
  mergeTwoLists(ListNode list1, ListNode list2) {
    if(list1 == null) {
      return list2;
    }
    if(list2 == null) {
      return list1;
    }
    int a = list1.val;
    int b = list2.val;
    ListNode head = null;
    if(a < b) {
      ListNode next1 = list1.next;
      list1.next = mergeTwoLists(list1.next, list2);
      head = list1;
    } else {
      list2.next = mergeTwoLists(list1, list2.next);
      head = list2;
    }
    return head;
  }
}






