package leetcode.problem459;

import core.Solution;
import leetcode.problem107.Solution0;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Solutions {
    static List<core.Solution> solutions =
        new ArrayList<>();
    
    static {
        class Solution0
            extends leetcode.problem459.Solution0
            implements core.Solution  {
            
            @Override
            public String describe() {
                return null;
            }
            @Override
            public URL link() {
                return null;
            }
        }
        solutions.add(new Solution0());
    }
}
