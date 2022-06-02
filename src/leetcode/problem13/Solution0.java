package leetcode.problem13;
import java.util.*;

class Solution0 {
  private Map<Character, Integer> memo = new HashMap<>();
  private void initMemo() {
    memo.put('I', 1);
    memo.put('V', 5);
    memo.put('X', 10);
    memo.put('L', 50);
    memo.put('C', 100);
    memo.put('D', 500);
    memo.put('M', 1000);
  }
  int convert(String s, int i) {
    if(i == s.length()) {
      return 0;
    }
    char c = s.charAt(i);
    if(i == s.length() - 1) {
      return this.memo.get(c);
    }

    char nextC = s.charAt(i + 1);
    if(c == 'I' && nextC == 'V') {
      return 4 + convert(s, i + 2);
    }
    else if(c == 'I' && nextC == 'X') {
      return 9 + convert(s, i + 2);
    }
    else if(c == 'X' && nextC == 'L') {
      return 40 + convert(s, i + 2);
    }
    else if(c == 'X' && nextC == 'C') {
      return 90 + convert(s, i + 2);
    }
    else if(c == 'C' && nextC == 'D') {
      return 400 + convert(s, i + 2);
    }
    else if(c == 'C' && nextC == 'M') {
      return 900 + convert(s, i + 2);
    }
    else {
      return memo.get(c) + convert(s, i + 1);
    }
  }
  public int romanToInt(String s) {
    initMemo();
    return convert(s, 0);
  }
}