package leetcode.problem150;

import java.util.Stack;
import java.util.function.BiFunction;

public class Solution0 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> context = new Stack<>();
        for(String s : tokens) {
            switch(s) {
                case "+":
                    doArith(context, (a, b) -> a + b);
                    break;
                case "-":
                    doArith(context, (a, b) -> a - b);
                    break;
                case "*":
                    doArith(context, (a, b) -> a * b);
                    break;
                case "/":
                    doArith(context, (a, b) -> a / b);
                    break;
                default:
                    context.push(Integer.valueOf(s));
            }
        }
        if(context.isEmpty()) return -1;
        return context.pop();
    }
    private void doArith(Stack<Integer> context, BiFunction<Integer, Integer, Integer> op) {
        int a = context.pop();
        int b = context.pop();
        context.push(op.apply(b, a));
    }
}
