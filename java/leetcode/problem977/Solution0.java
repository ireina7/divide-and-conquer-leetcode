package leetcode.problem977;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution0 {
    public int[] sortedSquares(int[] nums) {
        var xs = Arrays.stream(nums)
            .boxed()
            .map(i -> i * i)
            .sorted()
            .collect(Collectors.toList());
        int[] ans = new int[nums.length];
        for(int i = 0; i < xs.size(); ++i) {
            ans[i] = xs.get(i);
        }
        return ans;
    }
}
