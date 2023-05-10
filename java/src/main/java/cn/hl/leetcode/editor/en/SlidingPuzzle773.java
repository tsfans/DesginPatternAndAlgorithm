package cn.hl.leetcode.editor.en;
//On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty 
//square represented by 0. A move consists of choosing 0 and a 4-directionally 
//adjacent number and swapping it. 
//
// The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]
//]. 
//
// Given the puzzle board board, return the least number of moves required so 
//that the state of the board is solved. If it is impossible for the state of the 
//board to be solved, return -1. 
//
// 
// Example 1: 
//
// 
//Input: board = [[1,2,3],[4,0,5]]
//Output: 1
//Explanation: Swap the 0 and the 5 in one move.
// 
//
// Example 2: 
//
// 
//Input: board = [[1,2,3],[5,4,0]]
//Output: -1
//Explanation: No number of moves will make the board solved.
// 
//
// Example 3: 
//
// 
//Input: board = [[4,1,2],[5,0,3]]
//Output: 5
//Explanation: 5 is the smallest number of moves that solves the board.
//An example path:
//After move 0: [[4,1,2],[5,0,3]]
//After move 1: [[4,1,2],[0,5,3]]
//After move 2: [[0,1,2],[4,5,3]]
//After move 3: [[1,0,2],[4,5,3]]
//After move 4: [[1,2,0],[4,5,3]]
//After move 5: [[1,2,3],[4,5,0]]
// 
//
// 
// Constraints: 
//
// 
// board.length == 2 
// board[i].length == 3 
// 0 <= board[i][j] <= 5 
// Each value board[i][j] is unique. 
// 
// Related Topics Array Breadth-First Search Matrix 👍 1387 👎 36

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle773 {
    public static void main(String[] args) {
        Solution solution = new SlidingPuzzle773().new Solution();
        int[][] board = new int[][]{{1, 2, 3}, {4, 0, 5}};
        int res = solution.slidingPuzzle(board);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[][] neighbor = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {3, 5, 1}, {4, 2}};

        /**
         * BFS解法
         * 1.将二维数组转化为字符串,起点为初始字符串,终点为123450
         * 2.节点前进的方式为找到0的位置,将0与相邻节点互换
         * 3.方便起见可以写死每个节点的相邻位置
         */
        public int slidingPuzzle(int[][] board) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    sb.append(board[i][j]);
                }
            }
            String start = sb.toString();
            String target = "123450";
            Queue<String> q = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            q.add(start);
            visited.add(start);

            int step = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                // 当前队列所有节点前进一步
                for (int i = 0; i < size; i++) {
                    String curr = q.poll();
                    // 判断是否到终点
                    if (curr.equals(target)) {
                        return step;
                    }
                    // 找到0的位置,与相邻节点交换
                    int index0 = 0;
                    while (curr.charAt(index0) != '0') {
                        index0++;
                    }
                    for (int n : neighbor[index0]) {
                        String swap = swap(curr, index0, n);
                        // 避免重复访问
                        if (!visited.contains(swap)) {
                            q.add(swap);
                            visited.add(swap);
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        private String swap(String curr, int index0, int n) {
            char[] chars = curr.toCharArray();
            char tmp = chars[index0];
            chars[index0] = chars[n];
            chars[n] = tmp;
            return String.valueOf(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}