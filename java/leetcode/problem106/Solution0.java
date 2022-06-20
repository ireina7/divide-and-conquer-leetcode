package leetcode.problem106;

import java.util.Arrays;

public class Solution0 {
    int[] inorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        this.inorder = inorder;
        this.postorder = postorder;
        return dfs(0, inorder.length - 1, 0, postorder.length - 1);
    }
    /**
     * @param i1 start index of array inorder
     * @param j1 end index of array inorder
     * @param i2 start index of array postorder
     * @param j2 end index of array postorder
     * */
    TreeNode dfs(int i1, int j1, int i2, int j2) {
        if (i1 > j1 || i2 > j2) {
            return null;
        }
        if (i1 == j1 || i2 == j2) {
            return new TreeNode(inorder[i1]);
        }
        TreeNode root = new TreeNode(postorder[j2]);
        int ii = -1;
        for (int i = i1; i <= j1; ++i) {
            if (inorder[i] == root.val) {
                ii = i;
                break;
            }
        }
        root.left = dfs(i1, ii - 1, i2, i2 + ii - i1 - 1);
        root.right = dfs(ii + 1, j1, i2 + ii - i1, j2 - 1);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}