// 其他的for套了四层，我看得有点云里雾里。哭

// 提供一种思路：
// n的时候，从n-1的答案里，遍历插入()，从下标为0，一路插到最后。set去重。就是最后的答案。

// 思路好理解，就是性能有点拉。
class Solution {
    HashMap<Integer, Set<String>> memo = new HashMap<>();
    public List<String> generateParenthesis(int n) {
        return new ArrayList(dfs(n));
    }

    public Set<String> dfs(int n){
        if(memo.get(n) != null) return memo.get(n);
        
        if(n == 0) return new HashSet<>();
        if(n == 1) return new HashSet<>(){{add("()");}};
        
        Set<String> res = new HashSet<>();

        for(String oneAns : dfs(n - 1)){
            for(int i = 0; i < oneAns.length(); i++){
                res.add(oneAns.substring(0, i) + "()" + oneAns.substring(i, oneAns.length()));
            }
        }
        memo.put(n, res);
        return res;
    }
}