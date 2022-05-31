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
class Solution {
  /**
  Well, we are in the world of linked lists, we have to use divide type 0.
   */
    ListNode add(ListNode l1, ListNode l2, int c) {
        if(l1 == null && l2 == null) {
            if(c == 0) return null;
            else return new ListNode(1);
        }
        if(l1 == null) return add(l2, l1, c);
        if(l2 == null) {
            // save some space
            int sum = l1.val + c;
            l1.val = sum % 10;
            l1.next = add(l1.next, l2, sum / 10);
            return l1;
        }
        int sum = l1.val + l2.val + c;
        ListNode node = new ListNode();
        node.val = sum % 10;
        node.next = add(l1.next, l2.next, sum / 10);
        return node;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }
}