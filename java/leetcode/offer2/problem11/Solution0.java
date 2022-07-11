package leetcode.offer2.problem11;

import java.util.HashMap;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int findMaxLength(int[] nums) {
        int pre0 = 0, pre1 = 0;
        int ans = 0;
        Map<Integer, Integer> mem = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            pre0 += nums[i] == 0 ? 1 : 0;
            pre1 += nums[i] == 1 ? 1 : 0;
            int count = i + 1 - (pre0 == pre1 ? 0
                : mem.containsKey(pre0 - pre1) ? mem.get(pre0 - pre1)
                : i + 1
            );
            if (!mem.containsKey(pre0 - pre1))
                mem.put(pre0 - pre1, i + 1);
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
