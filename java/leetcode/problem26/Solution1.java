package leetcode.problem26;

public class Solution1 {
    int[] nums;
    public int removeDuplicates(int[] nums) {
        this.nums = nums;
        return remove(nums.length - 1);
    }
    int remove(int i) {
        if(i == 0) {
            return 1;
        }
        int n = remove(i - 1);
        if(nums[i] != nums[i - 1]) {
            nums[n] = nums[i];
            n += 1;
        }
        return n;
    }
}
