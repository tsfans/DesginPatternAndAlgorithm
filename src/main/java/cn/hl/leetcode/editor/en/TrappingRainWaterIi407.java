package cn.hl.leetcode.editor.en;
//Given an m x n integer matrix heightMap representing the height of each unit 
//cell in a 2D elevation map, return the volume of water it can trap after raining.
// 
//
// 
// Example 1: 
//
// 
//Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
//Output: 4
//Explanation: After the rain, water is trapped between the blocks.
//We have two small ponds 1 and 3 units trapped.
//The total volume of water trapped is 4.
// 
//
// Example 2: 
//
// 
//Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3
//]]
//Output: 10
// 
//
// 
// Constraints: 
//
// 
// m == heightMap.length 
// n == heightMap[i].length 
// 1 <= m, n <= 200 
// 0 <= heightMap[i][j] <= 2 * 10⁴ 
// 
// Related Topics Array Breadth-First Search Heap (Priority Queue) Matrix 👍 255
//7 👎 57

public class TrappingRainWaterIi407 {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWaterIi407().new Solution();
//        int[][] hm = new int[][]{{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}};
        int[][] hm = new int[][]{{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}};
        int res = solution.trapRainWater(hm);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trapRainWater(int[][] hm) {
            int m = hm.length, n = hm[0].length;
            if (m == 1 || n == 1) {
                return 0;
            }
            int[][] leftMax = new int[m][n];
            int[][] rightMax = new int[m][n];
            int[][] upMax = new int[m][n];
            int[][] downMax = new int[m][n];

            for (int i = 0; i < m; i++) {
                leftMax[i][0] = hm[i][0];
                rightMax[i][n - 1] = hm[i][n - 1];
                for (int j = 1; j < n; j++) {
                    leftMax[i][j] = Math.max(hm[i][j], leftMax[i][j - 1]);
                }
                for (int j = n - 2; j >= 0; j--) {
                    rightMax[i][j] = Math.max(hm[i][j], rightMax[i][j + 1]);
                }
            }
            for (int j = 0; j < n; j++) {
                upMax[0][j] = hm[0][j];
                downMax[m - 1][j] = hm[m - 1][j];
                for (int i = 1; i < m; i++) {
                    upMax[i][j] = Math.max(hm[i][j], upMax[i - 1][j]);
                }
                for (int i = m - 2; i >= 0; i--) {
                    downMax[i][j] = Math.max(hm[i][j], downMax[i + 1][j]);
                }
            }

            int water = 0;
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int minRow = Math.min(leftMax[i][j], rightMax[i][j]);
                    int minCol = Math.min(upMax[i][j], downMax[i][j]);
                    int min = Math.min(minRow, minCol);
                    if (min < hm[i][j]) {
                        min = hm[i][j];
                    }
                    water += min - hm[i][j];
                }
            }
            return water;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}