package leetcode.problem143;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Recursion";
    }
    
    ListNode pre;
    int count = 0;
    @Override
    public void reorderList(ListNode head) {
        this.pre = head;
        dfs(head);
    }
    public void dfs(ListNode head){
        if(head == null || head.next == null) {
            count /= 2;
            return;
        }
        count++;
        dfs(head.next);
        if(count > 0) {
            ListNode movedNode = head.next;
            head.next = null;
            movedNode.next = pre.next;
            pre.next = movedNode;
            pre = movedNode.next;
            count--;
        }
    }
}

