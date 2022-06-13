package leetcode.problem209;
import java.util.*;

public class Solution0 {
    int[] nums;
    int target;
    public int minSubArrayLen(int target, int[] nums) {
        this.nums = nums;
        this.target = target;
        return dfs(nums.length - 1);
    }
    int dfs(int i) {
        if(i <  0) return 0;
        if(i == 0) return nums[0] >= target ? 1 : 0;
        int pre = dfs(i - 1);
        int cur = 1;
        for(int j = i - 1, sum = nums[i]; j >= 0 && sum < target; --j) {
            cur += 1;
            sum += nums[j];
        }
        if(pre == 0) return cur;
        if(cur == 0) return pre;
        return Math.min(pre, cur);
    }
}
