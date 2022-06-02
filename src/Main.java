import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    var solution = new leetcode.problem1.Solution0();
    var ans = solution.twoSum(new int[]{1,2,-2,3}, 0);
    Arrays.stream(ans).forEach(
        n -> System.out.println(n)
    );
  }
}
