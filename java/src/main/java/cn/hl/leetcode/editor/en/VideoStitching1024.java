package cn.hl.leetcode.editor.en;
//You are given a series of video clips from a sporting event that lasted time 
//seconds. These video clips can be overlapping with each other and have varying 
//lengths. 
//
// Each video clip is described by an array clips where clips[i] = [starti, 
//endi] indicates that the ith clip started at starti and ended at endi. 
//
// We can cut these clips into segments freely. 
//
// 
// For example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
// 
// 
//
// Return the minimum number of clips needed so that we can cut the clips into 
//segments that cover the entire sporting event [0, time]. If the task is 
//impossible, return -1. 
//
// 
// Example 1: 
//
// 
//Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10
//Output: 3
//Explanation: We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
//Then, we can reconstruct the sporting event as follows:
//We cut [1,9] into segments [1,2] + [2,8] + [8,9].
//Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0,
// 10].
// 
//
// Example 2: 
//
// 
//Input: clips = [[0,1],[1,2]], time = 5
//Output: -1
//Explanation: We cannot cover [0,5] with only [0,1] and [1,2].
// 
//
// Example 3: 
//
// 
//Input: clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2
//,5],[2,6],[3,4],[4,5],[5,7],[6,9]], time = 9
//Output: 3
//Explanation: We can take clips [0,4], [4,7], and [6,9].
// 
//
// 
// Constraints: 
//
// 
// 1 <= clips.length <= 100 
// 0 <= starti <= endi <= 100 
// 1 <= time <= 100 
// 
// Related Topics Array Dynamic Programming Greedy 👍 1151 👎 47

import java.util.Arrays;

public class VideoStitching1024 {
    public static void main(String[] args) {
        Solution solution = new VideoStitching1024().new Solution();
        int[][] clips = new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        int res = solution.videoStitching(clips, 10);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int videoStitching(int[][] clips, int time) {
            // lastUtil[i]=j 表示所有起点为i的区间中,最大的终点为j
            int[] lastUtil = new int[time + 1];
            Arrays.fill(lastUtil, -1);
            for (int i = 0; i < clips.length; i++) {
                int start = clips[i][0], end = clips[i][1];
                // 在目标范围外的忽略即可
                if (start > time) {
                    continue;
                }
                lastUtil[start] = Math.max(lastUtil[start], Math.min(end, time));
            }

            int res = 1;
            // 当前最大终点
            int currEnd = lastUtil[0];
            if (currEnd == time) {
                return res;
            }
            int nextEnd = 0;
            for (int start = 1; start <= time; start++) {
                /**
                 * 当前起点超出当前终点,说明无法求解,因为需要保证两个区间相交
                 * |______|currEnd
                 *                |start
                 */
                if (start > currEnd) {
                    return -1;
                }
                // 计算当前最大终点
                nextEnd = Math.max(nextEnd, lastUtil[start]);
                if (nextEnd == time) {
                    // 如果可以覆盖目标区间,则选择此区间,选择次数加一
                    return res + 1;
                }
                // 当前起点已到达当前终点,需要更新当前终点为下一个终点,并将选择次数加一
                /**
                 * 当前起点已到达当前终点,需要更新当前终点为下一个终点,并将选择次数加一
                 * |______|currEnd 选择此区间
                 *        |start
                 */
                if (start == currEnd) {
                    currEnd = nextEnd;
                    res++;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}