package leetcode.problem77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return ans;
    }
    
    /**
     * 好吧，这里加上回溯写法。
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    void dfs(int n, int k, int startIndex) {
        //终止条件
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; ++i) {
            path.add(i);
            dfs(n, k, i + 1);
            path.removeLast();
        }
    }
}
