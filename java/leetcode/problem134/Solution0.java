package leetcode.problem134;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Traverse all, worst";
    }
    
    int[] gas;
    int[] cost;
    int n;
    int[] memo;
    int pre;
    @Override
    public int canCompleteCircuit(int[] gas, int[] cost) {
        this.gas = gas;
        this.cost = cost;
        this.n = gas.length;
        this.memo = new int[n];
        for (int i = 0; i < n; ++i) {
            if (dfs(i)) return i;
        }
        return -1;
    }
    boolean dfs(int i) {
        int left = gas[i];
        if (left == 0) return false;
        boolean ans = true;
        for (int j = i + 1; j < n; ++j) {
            if (left < cost[j - 1]) return false;
            left += gas[j] - cost[j - 1];
        }
        for (int j = 0; j <= i; ++j) {
            int cc = cost[j == 0 ? n - 1 : j - 1];
            if (left < cc) return false;
            left += gas[j] - cc;
        }
        pre = left;
        return ans;
    }
}
