package leetcode.problem27;
import java.util.*;

public class Solution0 {
    int[] nums;
    int val;
    public int removeElement(int[] nums, int val) {
        this.nums = nums;
        this.val = val;
        return remove(nums.length - 1);
    }
    int remove(int i) {
        return 0;
    }
}
