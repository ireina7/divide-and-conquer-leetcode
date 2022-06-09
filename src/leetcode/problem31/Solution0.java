package leetcode.problem31;
import java.util.*;

/**
 * https://leetcode.cn/problems/next-permutation/
 * */
public class Solution0 {
    int[] nums;
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        this.nums = nums;
        dfs(nums.length - 1, -1);
    }
    int dfs(int i, int pre) {
        if(i < 0) {
            reverse(nums); // reverse all => loop to the original
            return -1;
        }
        int x = nums[i];
        if(x >= pre) {
            int j = dfs(i - 1, x);
            if(j == -1) {
                return -1;
            }
            int d = i - j;
            if(pre <= nums[j] && x > nums[j]) {
                nums[nums.length - d] = nums[j];
                nums[j] = x;
            } else {
                nums[nums.length - d] = x;
            }
            return j;
        }
        return i;
    }
    public static void reverse(int[] xs) {
        int i = 0;
        int j = xs.length - 1;
        while(i < j) {
            int temp = xs[i];
            xs[i] = xs[j];
            xs[j] = temp;
            i++;
            j--;
        }
    }
}
