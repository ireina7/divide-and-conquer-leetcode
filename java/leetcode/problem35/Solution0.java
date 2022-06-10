package leetcode.problem35;
import java.util.*;

public class Solution0 {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while(i < j) {
            int k = i + ((j - i) >> 1);
            if(nums[k] == target) {
                return k;
            } else if(nums[k] < target) {
                i = k + 1;
            } else {
                j = k - 1;
            }
        }
        return i + (nums[i] < target ? 1 : 0);
    }
}
