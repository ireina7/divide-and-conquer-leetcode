package leetcode.problem241;
import java.util.*;

/**
 *
 * */
class Solution0 {
    HashMap<String, List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if(memo.containsKey(expression)) return memo.get(expression);
        List<Integer> res = new LinkedList<>();
        if(expression.length() <= 2){
            res.add(Integer.valueOf(expression));
            memo.put(expression, res);
            return res;
        }
        
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> leftSub = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightSub = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                for(int left : leftSub){
                    for(int right : rightSub){
                        if(c == '+'){
                            res.add(left + right);
                        }else if(c == '-'){
                            res.add(left - right);
                        }else if(c == '*'){
                            res.add(left * right);
                        }
                    }
                }
            }
        }
        memo.put(expression, res);
        return res;
    }
}