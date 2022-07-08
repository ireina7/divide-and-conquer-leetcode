package leetcode.problem718;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Solution0 extends Solution {
    
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int findLength(int[] nums1, int[] nums2) {
        int[][] mem = new int[nums1.length][nums2.length];
        int ans = 0;
        for (int i = 0; i < nums1.length; ++i) {
            for (int j = 0; j < nums2.length; ++j) {
                if (i == 0) {
                    mem[i][j] = nums1[i] == nums2[j] ? 1 : 0;
                }
                else if (j == 0) {
                    mem[i][j] = nums1[i] == nums2[j] ? 1 : 0;
                }
                else mem[i][j] =
                        nums1[i] == nums2[j] ? 1 + mem[i - 1][j - 1] : 0;
                ans = Math.max(ans, mem[i][j]);
            }
        }
        return ans;
    }
}






class SolutionBad extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    int[] nums1;
    int[] nums2;
    @Override
    public int findLength(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.memo = new int[nums1.length][nums2.length];
        this.preMemo = new int[nums1.length][nums2.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        for (int[] row : preMemo) {
            Arrays.fill(row, -1);
        }
        if (nums1.equals(nums2)) {
            return nums1.length;
        }
        int ans = dfs(nums1.length - 1, nums2.length - 1);
        return ans;
    }
    int pre;
    int[][] memo;
    int[][] preMemo;
    int dfs(int i, int j) {
        if (i == 0 && j == 0) {
            pre = nums1[i] == nums2[j] ? 1 : 0;
            return pre;
        }
        if (memo[i][j] != -1) {
            pre = preMemo[i][j];
            return memo[i][j];
        }
        if (i == 0) {
            if (nums1[0] == nums2[j]) {
                pre = 1;
                memo[i][j] = 1;
                preMemo[i][j] = 1;
                return 1;
            }
            int rest = dfs(i, j - 1);
            pre = 0;
            memo[i][j] = rest;
            preMemo[i][j] = 0;
            return rest;
        }
        if (j == 0) {
            if (nums1[i] == nums2[0]) {
                pre = 1;
                memo[i][j] = 1;
                preMemo[i][j] = 1;
                return 1;
            }
            
            int rest = dfs(i - 1, j);
            pre = 0;
            memo[i][j] = rest;
            preMemo[i][j] = 0;
            return rest;
        }
        if (nums1[i] == nums2[j]) {
            int rest = dfs(i - 1, j - 1);
            int ans = Math.max(rest, pre + 1);
            pre += 1;
            preMemo[i][j] = pre;
            int temp = pre;
            ans = Math.max(ans, dfs(i, j - 1));
            ans = Math.max(ans, dfs(i - 1, j));
            memo[i][j] = ans;
            pre = temp;
            return ans;
        }
        int ans = Math.max(dfs(i - 1, j), dfs(i, j - 1));
        pre = 0;
        memo[i][j] = ans;
        preMemo[i][j] = pre;
        return ans;
    }
}
