package leetcode.problem406;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) ->
            a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]
        );
        List<int[]> ans = new LinkedList<>();
        for(int[] p : people) {
            ans.add(p[1], p);
        }
        return ans.toArray(new int[people.length][]);
    }
}
