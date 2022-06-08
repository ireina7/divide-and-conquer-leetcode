package leetcode.problem27;
import java.util.*;

public class Solution0 {
    int[] nums;
    int val;
    public int removeElement(int[] nums, int val) {
        this.nums = nums;
        this.val = val;
        return remove(nums.length);
    }
    int remove(int i) {
        if(i == 0) {
            return 0;
        }
        int n = remove(i - 1);
        if(nums[i - 1] != val) {
            nums[n] = nums[i - 1];
            n += 1;
        }
        return n;
    }
}
