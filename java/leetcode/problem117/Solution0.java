package leetcode.problem117;

public class Solution0 {
    // Interesting...
    public Node connect(Node root) {
        if(root == null) return null;
        if(root.left != null) {
            root.left.next = root.right != null
                ? root.right
                : next(root.next);
        }
        if(root.right != null) {
            root.right.next = next(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
    Node next(Node node) {
        if(node == null) return null;
        if(node.left != null) return node.left;
        if(node.right != null) return node.right;
        return next(node.next);
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
