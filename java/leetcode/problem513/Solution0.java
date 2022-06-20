package leetcode.problem513;

import java.util.LinkedList;
import java.util.Queue;

public class Solution0 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leftMost = root.val;
        while (!queue.isEmpty()) {
            int len = queue.size();
            leftMost = queue.peek().val;
            for (int i = 0; i < len; ++i) {
                TreeNode node = queue.poll();
                if (node.left  != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return leftMost;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}