package leetcode.problem206;
import java.util.*;

public class Solution0 {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode last = head.next;
        ListNode rhead = reverseList(head.next);
        last.next = head;
        head.next = null;
        return rhead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}