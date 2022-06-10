package leetcode.problem33;

public class Solution0 {
    int[] nums;
    int target;
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return dfs(0, nums.length - 1);
    }
    int dfs(int i, int j) {
        if(i > j) {
            return -1;
        }
        if(i == j) {
            return nums[i] == target ? i : -1;
        }
        if(nums[i] == target) return i;
        if(nums[j] == target) return j;
        int k = i + ((j - i) >> 1);
        if(nums[k] == target) {
            return k;
        }
        if(nums[k] > target) {
            if(nums[k] > nums[j]) {
                return nums[i] > target
                    ? dfs(k + 1, j - 1)
                    : dfs(i + 1, k - 1);
            }
            return dfs(i + 1, k - 1);
        }
        if(nums[k] < nums[j]) {
            return nums[j] < target
                ? dfs(i + 1, k - 1)
                : dfs(k + 1, j - 1);
        }
        return dfs(k + 1, j - 1);
    }
}
