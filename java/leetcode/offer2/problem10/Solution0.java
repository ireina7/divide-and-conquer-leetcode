package leetcode.offer2.problem10;

import java.util.HashMap;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int subarraySum(int[] nums, int k) {
        int ans = 0, pre = 0;
        HashMap<Integer, Integer> mem = new HashMap<>();
        mem.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (mem.containsKey(pre - k)) {
                ans += mem.get(pre - k);
            }
            mem.put(pre, mem.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}
