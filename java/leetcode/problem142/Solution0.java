package leetcode.problem142;


public class Solution0 {
    public ListNode detectCycle(ListNode head) {
        ListNode i = head;
        ListNode j = head;
        while (j != null && j.next != null) {
            i = i.next;
            j = j.next.next;
            if (i == j) {
                ListNode a = head;
                ListNode b = j;
                
                while (a != b) {
                    a = a.next;
                    b = b.next;
                }
                return a;
            }
        }
        return null;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
