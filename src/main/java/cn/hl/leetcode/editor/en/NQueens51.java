package cn.hl.leetcode.editor.en;
//The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
//such that no two queens attack each other. 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//You may return the answer in any order. 
//
// Each solution contains a distinct board configuration of the n-queens' 
//placement, where 'Q' and '.' both indicate a queen and an empty space, respectively. 
//
// 
// Example 1: 
//
// 
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as 
//shown above
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [["Q"]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 9 
// 
// Related Topics Array Backtracking 👍 5165 👎 144

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens51 {
    public static void main(String[] args) {
        Solution solution = new NQueens51().new Solution();
        List<List<String>> res = solution.solveNQueens(4);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<String>> res;

        public List<List<String>> solveNQueens(int n) {
            res = new ArrayList<>();
            char[][] board = new char[n][n];
            for (char[] b : board) {
                Arrays.fill(b, '.');
            }
            nQueens(board, 0);
            return res;
        }

        /**
         * 回溯解决N皇后问题,条件为皇后不能互相攻击: 同行,同列,左上,右上,左下,右下可以互相攻击
         * 思路: 从上往下逐行放置皇后,每个位置只需检查同列,左上,右上(因为下方还未放置皇后)
         *
         * @param board 棋盘,记录皇后放置位置
         * @param row   当前放置皇后的行
         */
        void nQueens(char[][] board, int row) {
            // 结束条件: 每行都放置了皇后
            if (board.length == row) {
                res.add(new ArrayList<>(charArrayToList(board)));
                return;
            }
            // 遍历所有列
            int colLength = board[row].length;
            for (int col = 0; col < colLength; col++) {
                // 检查是否冲突
                if (!isValid(board, row, col)) {
                    continue;
                }
                // 放置皇后
                board[row][col] = 'Q';
                // 下一行
                nQueens(board, row + 1);
                // 取消放置
                board[row][col] = '.';
            }
        }

        /**
         * 同行,同列,左上,右上,左下,右下可以互相攻击
         * 从上往下逐行放置皇后,每个位置只需检查同列,左上,右上(因为下方还未放置皇后)
         *
         * @param board 棋盘数组
         * @param row   行
         * @param col   列
         * @return 能否在board[row][col]放置皇后
         */
        private boolean isValid(char[][] board, int row, int col) {
            int n = board.length;
            // 同行所有列检查
            for (int i = 0; i < n; i++) {
                if (board[i][col] == 'Q') {
                    return false;
                }
            }
            // 左上检查
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            // 右上检查
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }

        public List charArrayToList(char[][] board) {
            List<String> list = new ArrayList<>();
            for (char[] c : board) {
                list.add(String.copyValueOf(c));
            }
            return list;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}