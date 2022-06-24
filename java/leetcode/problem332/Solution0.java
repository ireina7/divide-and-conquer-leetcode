package leetcode.problem332;


import java.util.*;

public class Solution0 extends Solution {
    List<List<String>> tickets;
    Map<String, List<String>> memo;
    @Override
    public List<String> findItinerary(List<List<String>> tickets) {
        this.tickets = tickets;
        this.memo = new HashMap<>();
        for (var path : tickets) {
            String from = path.get(0), to = path.get(1);
            if (!memo.containsKey(from)) {
                List<String> tos = new LinkedList<>();
                tos.add(to);
                memo.put(from, tos);
            } else {
                memo.get(from).add(to);
            }
        }
        for (var entry : this.memo.entrySet()) {
            entry.getValue().sort(String::compareTo);
        }
        return dfs("JFK");
    }
    
    private List<String> dfs(String from) {
        List<String> ans = new ArrayList<>();
        if (memo.isEmpty()) return ans;
        if (!memo.containsKey(from)) return null;
        List<String> tos = memo.get(from);
        for (int i = 0; i < tos.size(); ++i) {
            String to = tos.get(i);
            List<String> nexts = new LinkedList<>(tos);
            if (nexts.size() == 1) {
                memo.remove(from);
            } else {
                nexts.remove(i);
                memo.put(from, nexts);
            }
            var rest = dfs(to);
            memo.put(from, tos);
            if (rest == null) continue;
            if (!memo.containsKey(to)) {
                rest.add(0, to);
            }
            rest.add(0, from);
            return rest;
        }
        return null;
    }
    
    @Override
    public String describe() {
        return "Half Backtracking";
    }
}
