package leetcode.problem1035;

import java.util.Arrays;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    int[] nums1;
    int[] nums2;
    int[][] mem;
    @Override
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.mem = new int[nums1.length][nums2.length];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        return dfs(nums1.length - 1, nums2.length - 1);
    }
    int dfs(int i, int j) {
        if (i == 0 && j == 0) {
            return nums1[0] == nums2[0] ? 1 : 0;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        int ans = 0;
        if (i == 0) {
            ans = nums1[i] == nums2[j] ? 1 : dfs(0, j - 1);
        } else if (j == 0) {
            ans = nums1[i] == nums2[j] ? 1 : dfs(i - 1, 0);
        } else {
            if (nums1[i] != nums2[j]) {
                ans = Math.max(dfs(i, j - 1), dfs(i - 1, j));
            } else {
                ans = 1 + dfs(i - 1, j - 1);
            }
        }
        mem[i][j] = ans;
        return ans;
    }
}
