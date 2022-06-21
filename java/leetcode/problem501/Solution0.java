package leetcode.problem501;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/find-mode-in-binary-search-tree/
 * */
public class Solution0 {
    List<Integer> ans;
    int maxCnt, preCnt;
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        this.ans = new ArrayList<>();
        dfs(root);
        int[] res = new int[ans.size()];
        IntStream.range(0, res.length)
            .forEach(i -> res[i] = ans.get(i));
        return res;
    }
    void dfs(TreeNode cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre != null && pre.val == cur.val) ++preCnt;
        else preCnt = 1;
        if (preCnt > maxCnt) {
            ans.clear();
            ans.add(cur.val);
            maxCnt = preCnt;
        } else if (preCnt == maxCnt) ans.add(cur.val);
        pre = cur;
        dfs(cur.right);
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