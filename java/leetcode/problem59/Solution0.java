package leetcode.problem59;
import java.util.*;

//1   2  3  4
//12 13 14  5
//11 16 15  6
//10  9  8  7
/**
 * https://leetcode.cn/problems/spiral-matrix-ii/
 * nonsense, I come to conquer you.
 * */
public class Solution0 {
    int n;
    int cur;
    int[][] ans;
    public int[][] generateMatrix(int n) {
        this.n = n;
        this.cur = 1;
        this.ans = new int[n][];
        for(int i = 0; i < n; ++i) {
            ans[i] = new int[n];
        }
        int anchor = n % 2 == 0 ? n / 2 : n / 2 + 1;
        for(int i = 0; i < anchor; ++i) {
            dfs(i, i, n - i * 2);
        }
        return ans;
    }
    void dfs(int x, int y, int width) {
        if(width == 1) {
            ans[x][y] = cur++;
            return;
        }
        int step = width - 1;
        for(int d = 0; d < step; ++d) {
            ans[x][y + d] = cur++;
        }
        for(int d = 0; d < step; ++d) {
            ans[x + d][y + width - 1] = cur++;
        }
        for(int d = 0; d < step; ++d) {
            ans[x + width - 1][y + width - d - 1] = cur++;
        }
        for(int d = 0; d < step; ++d) {
            ans[x + width - d - 1][y] = cur++;
        }
    }
}
