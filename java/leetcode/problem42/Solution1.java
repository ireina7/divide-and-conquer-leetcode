package leetcode.problem42;
import java.util.*;

public class Solution1 {
    public int trap(int[] height) {
        if(height.length <= 1) {
            return 0;
        }
        int[] hs = new int[height.length];
        int max = 0;
        for(int i = 1; i < hs.length; ++i) {
            if(height[i - 1] > max) {
                max = height[i - 1];
            }
            hs[i] = max;
        }
        max = 0;
        hs[hs.length - 1] = Math.min(0, hs[hs.length - 1]);
        for(int i = hs.length - 2; i >= 0; --i) {
            if(height[i + 1] > max) {
                max = height[i + 1];
            }
            hs[i] = Math.min(hs[i], max);
        }
        int ans = 0;
        for(int i = 0; i < hs.length; ++i) {
            if(hs[i] > height[i]) {
                ans += hs[i] - height[i];
            }
        }
        return ans;
    }
}
