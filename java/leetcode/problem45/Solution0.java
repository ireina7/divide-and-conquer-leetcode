package leetcode.problem45;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "naive divide and conquer";
    }
    
    int[] nums;
    @Override
    public int jump(int[] nums) {
        this.nums = nums;
        return dfs(0);
    }
    List<int[]> pre = new ArrayList<>();
    int dfs(int i) {
        if (i == nums.length - 1) {
            pre.add(new int[]{i, 0});
            return 0;
        }
        dfs(i + 1);
        int ans = Integer.MAX_VALUE;
        for (int[] ints : pre) {
            if (ints[0] > i + nums[i]) break;
            ans = Math.min(ans, ints[1] + 1);
        }
        if (ans != Integer.MAX_VALUE) {
            pre.add(0, new int[]{i, ans});
        }
        return ans;
    }
}
