package leetcode.problem51;

import java.util.*;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Backtracking";
    }
    
    char[][] board;
    int n;
    List<List<String>> ans = new ArrayList<>();
    @Override
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.board = new char[n][n];
        for (char[] row : this.board) {
            Arrays.fill(row, '.');
        }
        dfs(0);
        return ans;
    }
    void dfs(int i) {
        if (i >= board.length) {
            ans.add(arrayToList(board));
            return;
        }
        for (int j = 0; j < board[i].length; ++j) {
            if (!check(i, j)) continue;
            board[i][j] = 'Q';
            dfs(i + 1);
            board[i][j] = '.';
        }
    }
    boolean check(int row, int col) {
        // 检查列
        for (int i = 0; i < row; ++i) {
            if (board[i][col] == 'Q') return false;
        }
        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (board[i][j] == 'Q') return false;
        }
        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; --i, ++j) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
    List<String> arrayToList(char[][] board) {
        List<String> ans = new ArrayList<>();
        for (char[] chars : board) {
            String row = new String(chars);
            ans.add(row);
        }
        return ans;
    }
}
