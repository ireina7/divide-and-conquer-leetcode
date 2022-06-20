package leetcode.problem222;

public class Solution1 {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int dl = 0;
        int dr = 0;
        TreeNode cur = root;
        while(cur != null) {
            dl += 1;
            cur = cur.left;
        }
        cur = root;
        while(cur != null) {
            dr += 1;
            cur = cur.right;
        }
        if(dl == dr) {
            return (1 << dl) - 1;
        }
        return 1 +  countNodes(root.left) + countNodes(root.right);
    }
}
