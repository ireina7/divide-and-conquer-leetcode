package leetcode.offer.problem3;

import java.util.HashSet;
import java.util.Set;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public int findRepeatNumber(int[] nums) {
        Set<Integer> mem = new HashSet<>();
        for (int num : nums) {
            if (mem.contains(num)) return num;
            mem.add(num);
        }
        return 0;
    }
}
