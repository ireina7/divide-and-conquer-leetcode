package leetcode.offer2.problem24;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    ListNode tail;
    @Override
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            tail = head;
            return head;
        }
        ListNode next = reverseList(head.next);
        tail.next = head;
        tail = head;
        return next;
    }
}
