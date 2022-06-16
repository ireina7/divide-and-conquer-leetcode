package leetcode.problem347;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution0 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        var memo = map
            .entrySet()
            .stream()
            .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
            .collect(Collectors.toList());
        int[] ans = new int[k];
        for(int i = 0; i < k; ++i) {
            ans[i] = memo.get(i).getKey();
        }
        return ans;
    }
}
