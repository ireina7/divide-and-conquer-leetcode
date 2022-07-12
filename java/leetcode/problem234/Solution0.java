package leetcode.problem234;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Contextual recursion";
    }
    
    ListNode pre;
    public boolean isPalindrome(ListNode head) {
        pre = head;
        return check(head);
    }
    boolean check(ListNode head) {
        if(head == null) return true;
        boolean res = check(head.next) && (pre.val == head.val);
        pre = pre.next;
        return res;
    }
}
