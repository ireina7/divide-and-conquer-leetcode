package leetcode.offer2.problem13;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    int[][] mem;
    Solution0() {}
    Solution0(int[][] matrix) {
        if (matrix.length == 0) return;
        this.mem = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            int row = 0;
            for (int j = 0; j < matrix[0].length; ++j) {
                row += matrix[i][j];
                mem[i][j] = (i > 0 ? mem[i - 1][j] : 0) + row;
            }
        }
    }
    @Override
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return mem[row2][col2];
        }
        if (row1 == 0) {
            return mem[row2][col2] - mem[row2][col1 - 1];
        }
        if (col1 == 0) {
            return mem[row2][col2] - mem[row1 - 1][col2];
        }
        int upper = mem[row1 - 1][col2];
        int left = mem[row2][col1 - 1];
        int overlap = mem[row1 - 1][col1 - 1];
        return mem[row2][col2] - upper - left + overlap;
    }
}
