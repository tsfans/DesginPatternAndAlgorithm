package cn.hl.leetcode.editor.en;
//Given an array of intervals where intervals[i] = [starti, endi], merge all 
//overlapping intervals, and return an array of the non-overlapping intervals that 
//cover all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics Array Sorting 👍 12810 👎 508

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MergeIntervals56 {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals56().new Solution();
//        int[][] intervals = new int[][]{{1, 3}, {1, 6}, {8, 10}, {15, 18}};
        int[][] intervals = new int[][]{{1, 4}, {0, 4}};
        int[][] res = solution.merge(intervals);
        List<int[]> list = new ArrayList<>();
        list.toArray(new int[0][]);
        Map.Entry
        System.out.println(res.length);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1.sort intervals by start asc, if start equals then sort by end desc
         * 2.directly add none-overlapping, add overlapping intervals after merged
         * TC=O(NlogN), SC=O(N)
         */
        public int[][] merge(int[][] intervals) {
            // 1.sort intervals by start asc
            Arrays.sort(intervals, (i1, i2) -> i1[0] == i2[0] ? i2[1] - i1[1] : i1[0] - i2[0]);
            int currStart = -1, currEnd = -1;
            List<int[]> list = new ArrayList<>();
            for (int[] interval : intervals) {
                if (interval[1] <= currEnd) {
                    // skip covered intervals
                    continue;
                }
                if (interval[0] > currEnd) {
                    // directly add none-overlapping
                    list.add(interval);
                    currStart = interval[0];
                    currEnd = interval[1];
                } else {
                    // add overlapping intervals after merged
                    currEnd = interval[1];
                    list.remove(list.size() - 1);
                    list.add(new int[]{currStart, currEnd});

                }
            }
            int[][] res = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}