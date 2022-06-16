package leetcode.problem239;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/
 * */
public class Solution0 {
    int[] nums;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < k) return new int[]{};
        this.nums = nums;
        return dfs(k);
    }
    /**
     * Just divide k!
     * @param k the size of sliding window.
     * @return maximum number of each sliding.
     *
     * consider one sliding group, we can divide it into 2 equal parts:
     * |----k/2-----|----k/2----|
     * If we have the sliding window max number results of window size k/2,
     * then we get the maximum number in each sliding window of size k.
     * */
    int[] dfs(int k) {
        if(k == 1) return nums;
        int kk = k / 2;
        int[] ks = dfs(kk);
        int n = nums.length - k + 1;
        int[] ans = new int[n];
        for(int i = 0; i < n; ++i) {
            int max = Math.max(ks[i], ks[i + kk]);
            if(k % 2 == 1) {
                max = Math.max(nums[i + kk * 2], max);
            }
            ans[i] = max;
        }
        return ans;
    }
}
