package leetcode.problem144;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution0 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        var ls = preorderTraversal(root.left);
        var rs = preorderTraversal(root.right);
        ls.add(0, root.val);
        return Stream.concat(ls.stream(), rs.stream()).collect(Collectors.toList());
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