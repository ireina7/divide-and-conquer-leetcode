package leetcode.problem904;
import java.util.*;

public class Solution0 {
    int[] fruits;
    public int totalFruit(int[] fruits) {
        this.fruits = fruits;
        return dfs(0);
    }
    int dfs(int i) {
        if(i == fruits.length) {
            return 0;
        }
        int j = i + 1;
        while(j < fruits.length && fruits[j] == fruits[i]) ++j;
        int rs = dfs(j);
        if(j == fruits.length) {
            int ans = Math.max(j - i, rs);
            return ans;
        }
        int k = j + 1;
        while(k < fruits.length && (fruits[k] == fruits[i] || fruits[k] == fruits[j])) {
            ++k;
        }
        int ans = Math.max(k - i, rs);
        return ans;
    }
}
