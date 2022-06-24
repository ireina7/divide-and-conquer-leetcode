package leetcode.problem332;

import java.util.*;

public class Solution1 extends Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> ans = new LinkedList<>();
    
    @Override
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }
    /**
     * Backtracking is not necessary.
     * */
    void dfs(String from) {
        while (map.containsKey(from) && map.get(from).size() > 0) {
            String to = map.get(from).poll();
            dfs(to);
        }
        ans.add(from);
    }
    
    @Override
    public String describe() {
        return "Hierholzer algorithm";
    }
}
