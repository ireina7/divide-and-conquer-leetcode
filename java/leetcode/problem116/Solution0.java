package leetcode.problem116;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0 {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            Node cur = new Node();
            for(int i = 0; i < len; ++i) {
                cur.next = queue.poll();
                cur = cur.next;
                if(cur.left  != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            cur.next = null;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    
    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }
    
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
