package leetcode.problem977;
import java.util.*;

public class Solution1 {
    int[] nums;
    public int[] sortedSquares(int[] nums) {
        this.nums = nums;
        var xs = dfs(0, nums.length - 1);
        int[] ans = new int[nums.length];
        for(int i = 0; i < ans.length; ++i) {
            ans[i] = xs.get(i);
        }
        return ans;
    }
    List<Integer> dfs(int i, int j) {
        if(i == j) {
            List<Integer> ans = new ArrayList<>();
            ans.add(nums[i] * nums[i]);
            return ans;
        }
        int n;
        List<Integer> xs;
        if(Math.abs(nums[i]) > Math.abs(nums[j])) {
            n = nums[i] * nums[i];
            xs = dfs(i + 1, j);
        } else {
            n = nums[j] * nums[j];
            xs = dfs(i, j - 1);
        }
        xs.add(n);
        return xs;
    }
}
