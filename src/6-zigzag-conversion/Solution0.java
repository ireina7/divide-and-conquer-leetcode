class Solution {
    /**
    Type 0
    I hate this problem.
     */
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        char[][] cs = dfs(s, numRows, 0);
        StringBuilder ss = new StringBuilder();
        for(int i = 0; i < cs.length; ++i) {
            ss.append(new String(cs[i]).trim());
        }
        return ss.toString();
    }
    
    char[][] dfs(String s, int row, int i) {
        int n = (row - 1) * 2;
        char[][] ans = new char[row][];
        if(s.length() - i <= n) {
            ans = part(s, row, i);
            return ans;
        }
        char[][] c = part(s, row, i);
        char[][] cs = dfs(s, row, i + n);
        for(int j = 0; j < row; ++j) {
            int len1 = c[j].length;
            int len2 = cs[j].length;
            ans[j] = new char[len1 + len2];
            for(int k = 0; k < len1; ++k) {
                ans[j][k] = c[j][k];
            }
            for(int k = 0; k < len2; ++k) {
                ans[j][len1 + k] = cs[j][k];
            }
        }
        return ans;
    }
    char[][] part(String s, int row, int i) {
        int n = (row - 1) * 2;
        char[][] ans = new char[row][];
        for(int j = 0; j < row; ++j) {
            ans[j] = new char[]{};
        }
        for(int j = 0; i + j < s.length() && j < n; ++j) {
            if(j < row) {
                int size = j == 0 || j == row - 1 ? 1 : 2;
                ans[j] = new char[size];
                ans[j][0] = s.charAt(i + j);
            } else {
                int k = row - 2 - (j % row);
                ans[k][1] = s.charAt(i + j);
            }
        }
        return ans;
    }
}