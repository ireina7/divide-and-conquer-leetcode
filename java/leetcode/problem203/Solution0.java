package leetcode.problem203;
import java.util.*;

/**
 * https://leetcode.cn/problems/remove-linked-list-elements/
 * */
public class Solution0 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        if(head.val == val) return removeElements(head.next, val);
        head.next = removeElements(head.next, val);
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
