package leetcode.problem873;

import java.util.*;
import java.util.stream.Collectors;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> mem = new HashMap<Integer, Integer>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            mem.put(arr[i], i);
        }
        int[][] dp = new int[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                int k = mem.getOrDefault(arr[i] - arr[j], -1);
                if (k >= 0) {
                    dp[j][i] = Math.max(dp[k][j] + 1, 3);
                }
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }
    
    /** A working algorithm, however not optimal...
     * */
    public int lenLongestFibSubseqRecur(int[] arr) {
        int ans = 0;
        Map<Integer, List<int[]>> mem = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            if (mem.containsKey(arr[i])) {
                for (int[] r : mem.get(arr[i])) {
                    if (!mem.containsKey(r[1] + arr[i])) {
                        mem.put(r[1] + arr[i], new ArrayList<>());
                    }
                    mem.get(r[1] + arr[i]).add(new int[]{r[0] + 1, arr[i]});
                    ans = Math.max(ans, r[0] + 1);
                }
                mem.remove(arr[i]);
            }
            for (int[] r : mem.get(null)) {
                if (!mem.containsKey(r[1] + arr[i])) {
                    mem.put(r[1] + arr[i], new ArrayList<>());
                }
                mem.get(r[1] + arr[i]).add(new int[]{2, arr[i]});
            }
            mem.get(null).add(new int[]{1, arr[i]});
        }
        return ans;
    }
}
