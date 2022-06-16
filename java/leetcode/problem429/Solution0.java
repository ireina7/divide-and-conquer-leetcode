package leetcode.problem429;

import java.util.ArrayList;
import java.util.List;

public class Solution0 {
    List<List<Integer>> ans;
    public List<List<Integer>> levelOrder(Node root) {
        this.ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
    }
    void dfs(Node node, int depth) {
        if(node == null) return;
        if(ans.size() < depth + 1) {
            ans.add(new ArrayList<>());
        }
        ans.get(depth).add(node.val);
        for(Node child : node.children) {
            dfs(child, depth + 1);
        }
    }
}

class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
