package leetcode.problem36;
import java.util.*;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/valid-sudoku/
 * */
public class Solution0 {
    char[][] board;
    int width;
    int height;
    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        this.width = board[0].length;
        this.height = board.length;
        boolean rowsCols = validRows() && validCols();
        boolean cells =
            validCell(0,0) && validCell(0, 3) && validCell(0, 6) &&
            validCell(3,0) && validCell(3, 3) && validCell(3, 6) &&
            validCell(6,0) && validCell(6, 3) && validCell(6, 6) ;
        return rowsCols && cells;
    }
    boolean validRows() {
        return IntStream
            .range(0, height)
            .boxed()
            .map(i -> validRow(i))
            .reduce(true, (a, b) -> a && b);
    }
    boolean validRow(int i) {
        Set<Character> memo = new HashSet<>();
        for(int j = 0; j < width; ++j) {
            char c = board[i][j];
            if(c != '.' && memo.contains(c)) {
                return false;
            }
            memo.add(c);
        }
        return true;
    }
    boolean validCols() {
        return IntStream
            .range(0, width)
            .boxed()
            .map(j -> validCol(j))
            .reduce(true, (a, b) -> a && b);
    }
    boolean validCol(int j) {
        Set<Character> memo = new HashSet<>();
        for(int i = 0; i < height; ++i) {
            char c = board[i][j];
            if(c != '.' && memo.contains(c)) {
                return false;
            }
            memo.add(c);
        }
        return true;
    }
    boolean validCell(int i, int j) {
        Set<Character> memo = new HashSet<>();
        int n = 3;
        for(int p = 0; p < n; ++p) {
            for(int q = 0; q < n; ++q) {
                char c = board[i + p][j + q];
                if(c != '.' && memo.contains(c)) {
                    return false;
                }
                memo.add(c);
            }
        }
        return true;
    }
}
