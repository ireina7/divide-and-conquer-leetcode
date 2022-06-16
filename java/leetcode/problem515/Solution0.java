package leetcode.problem515;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution0 {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return List.of();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int len = queue.size();
            for(int i = 0; i < len; ++i) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if(node.left  != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            ans.add(max);
        }
        return ans;
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