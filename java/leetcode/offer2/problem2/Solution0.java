package leetcode.offer2.problem2;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int inc = 0;
        int i = a.length() - 1, j = b.length() - 1;
        for (; i >= 0 && j >= 0; --i, --j) {
            int x = a.charAt(i) == '0' ? 0 : 1;
            int y = b.charAt(j) == '0' ? 0 : 1;
            int sum = x + y + inc;
            int z = sum % 2;
            inc = sum <= 1 ? 0 : 1;
            sb.append(z == 0 ? '0' : '1');
        }
        if (i >= 0) {
            for (; i >=0; --i) {
                int x = a.charAt(i) == '0' ? 0 : 1;
                int sum = x + inc;
                int z = sum % 2;
                inc = sum <= 1 ? 0 : 1;
                sb.append(z == 0 ? '0' : '1');
            }
        }
        if (j >= 0) {
            for (; j >=0; --j) {
                int x = b.charAt(j) == '0' ? 0 : 1;
                int sum = x + inc;
                int z = sum % 2;
                inc = sum <= 1 ? 0 : 1;
                sb.append(z == 0 ? '0' : '1');
            }
        }
        if (inc == 1) sb.append('1');
        return sb.reverse().toString();
    }
}
