package leetcode.problem430;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Recursion";
    }
    
    Node last;
    @Override
    public Node flatten(Node head) {
        return dfs(head);
    }
    Node dfs(Node head) {
        if (head == null) return null;
        if (head.next == null && head.child == null) {
            last = head;
            return head;
        }
        if (head.child != null) {
            Node next = dfs(head.child);
            Node nextNext = head.next;
            head.next = next;
            next.prev = head;
            Node last_ = last;
            if (nextNext != null) {
                last_.next = dfs(nextNext);
                nextNext.prev = last_;
            }
            head.child = null;
        } else {
            head.next = dfs(head.next);
        }
        return head;
    }
}
