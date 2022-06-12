package leetcode.problem42;
import java.util.*;

/**
 * https://leetcode.cn/problems/trapping-rain-water/
 * */
public class Solution0 {
    int[] hs;
    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        this.hs = height;
        int j = Arrays.stream(hs).max().getAsInt();
        return dac(0, j);
    }
    int dac(int i, int j) {
        if(i > j) {
            return 0;
        }
        if(i < j) {
            int k = i + ((j - i) >> 1);
            int upper = dac(i, k);
            int lower = dac(k + 1, j);
            return upper + lower;
        }
        if(i == 0) {
            int sum = 0;
            int pre = 0;
            for(int p = 0; p < hs.length; ++p) {
                // this is underwork!
            }
        }
        return 0;
    }
}
