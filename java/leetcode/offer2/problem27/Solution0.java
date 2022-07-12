package leetcode.offer2.problem27;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Contextual recursion";
    }
    
    ListNode pre;
    @Override
    public boolean isPalindrome(ListNode head) {
        this.pre = head;
        return head != null && dfs(head);
    }
    boolean dfs(ListNode head) {
        if (head.next == null) {
            boolean ans = head.val == pre.val;
            pre = pre.next;
            return ans;
        }
        boolean ans = dfs(head.next);
        ans = ans && head.val == pre.val;
        pre = pre.next;
        return ans;
    }
}
