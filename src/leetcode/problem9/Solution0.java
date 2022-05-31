package leetcode.problem9;

public class Solution0 {
  public boolean isPalindrome(int x) {
    String s = Integer.valueOf(x).toString();
    StringBuilder ss = new StringBuilder(s);
    return ss.reverse().toString().equals(s);
  }
}
