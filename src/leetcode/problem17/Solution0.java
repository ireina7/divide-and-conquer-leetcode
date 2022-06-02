package leetcode.problem17;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * */
public class Solution0 {
  Map<Character, String> mem = Map.of(
      '1', "",
      '2', "abc",
      '3', "def",
      '4', "ghi",
      '5', "jkl",
      '6', "mno",
      '7', "pqrs",
      '8', "tuv",
      '9', "wxyz"
  );
  public List<String> letterCombinations(String digits) {
    if(digits.isEmpty()) {
      return List.of();
    }
    return dfs(digits).collect(Collectors.toList());
  }

  Stream<String> dfs(String digits) {
    if(digits.isEmpty()) return Stream.of("");
    return
        mem.get(digits.charAt(0)).chars().boxed().flatMap(
            c -> dfs(digits.substring(1)).map(s -> (char)(int)c + s)
        );
  }
}
