import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
      public static void main(String[] args) {
        var solution = new leetcode.problem22.Solution0();
        var ans = solution.generateParenthesis(6);
        System.out.println("Results:");
        System.out.println(ans.size());
        ans.stream().forEach(
            s -> System.out.println(s)
        );
      }
}
