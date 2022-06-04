package leetcode.problem20;
import javax.swing.text.html.Option;
import java.util.*;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 * */
public class Solution0 {
  boolean match(char a, char b) {
    return
        a == '(' && b == ')' ||
        a == '[' && b == ']' ||
        a == '{' && b == '}';
  }
  public boolean
  isValid(String s) {
    Stack<Character> stk = new Stack<>();
    s.chars().boxed().map(i -> (char)(int)i).forEach(
        c -> {
          if(stk.empty()) {
            stk.push(c);
          }
          else if (match(stk.peek(), c)) {
            stk.pop();
          } else {
            stk.push(c);
          }
        }
    );
    return stk.empty();
  }
}


