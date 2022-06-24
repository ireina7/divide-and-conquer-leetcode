package leetcode.problem376;

import java.util.LinkedList;

public class Solution0 extends Solution {
    
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    int[] nums;
    int n;
    @Override
    public int wiggleMaxLength(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        int[] ab = dfs(0);
        return Math.max(ab[0], ab[1]);
    }
    int[] dfs(int i) {
        if (i == n) return new int[]{0, 0};
        if (i == n - 1) return new int[]{1, 1};
        
        int[] res = dfs(i + 1);
        int up = res[0], down = res[1];
        return nums[i] > nums[i + 1]
            ? new int[]{up, Math.max(down, up + 1)}
            : nums[i] < nums[i + 1] ? new int[]{Math.max(up, down + 1), down}
            : new int[]{up, down};
    }
}
