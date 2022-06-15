package leetcode.problem1047;

import java.util.Stack;

public class Solution0 {
    char[] cs;
    public String removeDuplicates(String s) {
        this.cs = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        for(char c : cs) {
            if(stk.isEmpty()) stk.push(c);
            else if(stk.peek() == c) stk.pop();
            else stk.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
