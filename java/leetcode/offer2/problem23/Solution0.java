package leetcode.offer2.problem23;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode i = headA, j = headB;
        while (i != j) {
            i = i == null ? headB : i.next;
            j = j == null ? headA : j.next;
        }
        return i;
    }
}
