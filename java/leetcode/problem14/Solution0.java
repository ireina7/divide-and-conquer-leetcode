package leetcode.problem14;
import java.util.*;

public class Solution0 {
  String[] ss;
  public String longestCommonPrefix(String[] strs) {
    this.ss = strs;
    if(ss.length == 1) {
      return ss[0];
    } else if(ss.length == 0) {
      return "";
    } else {
      return dfs(0);
    }
  }
  String dfs(int i) {
    for(int j = 1; j < ss.length; ++j) {
      if(i >= ss[j].length()) {
        return "";
      }
      if(ss[j].charAt(i) != ss[0].charAt(i)) {
        return "";
      }
    }
    String rest = dfs(i + 1);
    return String.format("%s%s", ss[0].charAt(i), rest);
  }
}
