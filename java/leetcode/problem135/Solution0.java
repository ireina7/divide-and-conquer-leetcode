package leetcode.problem135;

import java.util.Arrays;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    int[] rate;
    int pre;
    int bound;
    @Override
    public int candy(int[] ratings) {
        this.rate = ratings;
        int ans = 0;
        int len = ratings.length;
        int[] rs = new int[len];
        int[] ls = new int[len];
        Arrays.fill(ls, 1);
        Arrays.fill(rs, 1);
        for (int i = 1; i < len; ++i) {
            if (ratings[i] > ratings[i - 1]) rs[i] = rs[i - 1] + 1;
        }
        for (int i = len - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) ls[i] = ls[i + 1] + 1;
        }
        for (int i = 0; i < len; ++i) {
            ans += Math.max(ls[i], rs[i]);//取交集
        }
        return ans;
    }
//    int dfs(int i) {
//        if (i == rate.length - 1) {
//            pre = 1;
//            bound = i;
//            return 1;
//        }
//        int ans = 1;
//        int rest = dfs(i + 1);
//        if (rate[i] > rate[i + 1]) {
//            pre = pre + 1;
//            bound = i;
//        } else if (rate[i] == rate[i + 1]) {
//            pre = 1;
//        } else {
//            if (pre > 1) {
//                pre = 1;
//            } else {
//                pre = 1;
//                rest += bound - i;
//            }
//        }
//        ans = rest + pre;
//        System.out.printf("%d, %d, %d", i, pre, bound);
//        return ans;
//    }
}
