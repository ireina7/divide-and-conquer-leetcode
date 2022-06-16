package leetcode.problem102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return bfs(root);
    }
    List<List<Integer>> bfs(TreeNode root) {
        if(root == null) return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            int len = queue.size();
            for(int i = 0; i < len; ++i) {
                TreeNode node = queue.poll();
                layer.add(node.val);
                if(node.left  != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            ans.add(layer);
        }
        return ans;
    }
}
