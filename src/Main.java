import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    var solution = new leetcode.problem18.Solution0();
    var ans = solution.fourSum(new int[]{0, 0, 0, 0}, 0);
    System.out.println("Results:");
    System.out.println(ans.size());
    ans.stream().forEach(
        xs -> {
          xs.stream().forEach(x -> System.out.printf("%d, ", x));
          System.out.println();
        }
    );
  }
}
