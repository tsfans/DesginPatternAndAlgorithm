package cn.hl.leetcode.editor.en;
//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be 
//validated according to the following rules: 
//
// 
// Each row must contain the digits 1-9 without repetition. 
// Each column must contain the digits 1-9 without repetition. 
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 
//without repetition. 
// 
//
// Note: 
//
// 
// A Sudoku board (partially filled) could be valid but is not necessarily 
//solvable. 
// Only the filled cells need to be validated according to the mentioned rules. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner 
//being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is 
//invalid.
// 
//
// 
// Constraints: 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] is a digit 1-9 or '.'. 
// 
// Related Topics Array Hash Table Matrix 👍 4605 👎 677

public class ValidSudoku36 {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku36().new Solution();
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean res = solution.isValidSudoku(board);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int m = board.length;
            int n = board[0].length;

            // check rows
            for (int i = 0; i < m; i++) {
                int[] arr = new int[10];
                for (int j = 0; j < n; j++) {
                    char curr = board[i][j];
                    int index = curr == '.' ? 0 : Integer.valueOf(String.valueOf(curr));
                    if (curr != '.' && arr[index] != 0) {
                        return false;
                    }
                    arr[index]++;
                }
            }

            // check columns
            for (int j = 0; j < n; j++) {
                int[] arr = new int[10];

                for (int i = 0; i < m; i++) {
                    char curr = board[i][j];
                    int index = curr == '.' ? 0 : Integer.valueOf(String.valueOf(curr));
                    if (curr != '.' && arr[index] != 0) {
                        return false;
                    }
                    arr[index]++;
                }
            }

            // check sub-boxes
            int rowLoop = m / 3;
            int colLoop = n / 3;
            for (int i = 0; i < rowLoop; i++) {
                int startRow = +3 * i;
                int endRow = startRow + 2;
                for (int j = 0; j < colLoop; j++) {
                    int startCol = 3 * j;
                    int endCol = startCol + 2;
                    if (!valid(board, startRow, endRow, startCol, endCol)) {
                        return false;
                    }
                }
            }
            return true;
        }

        boolean valid(char[][] board, int startRow, int endRow, int startCol, int endCol) {
            int[] arr = new int[10];
            for (int i = startRow; i <= endRow; i++) {
                for (int j = startCol; j <= endCol; j++) {
                    char curr = board[i][j];
                    int index = curr == '.' ? 0 : Integer.valueOf(String.valueOf(curr));
                    if (curr != '.' && arr[index] != 0) {
                        return false;
                    }
                    arr[index]++;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}