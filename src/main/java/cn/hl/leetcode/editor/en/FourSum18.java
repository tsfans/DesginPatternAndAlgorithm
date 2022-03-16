package cn.hl.leetcode.editor.en;
//Given an array nums of n integers, return an array of all the unique 
//quadruplets [nums[a], nums[b], nums[c], nums[d]] such that: 
//
// 
// 0 <= a, b, c, d < n 
// a, b, c, and d are distinct. 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2], target = 8
//Output: [[2,2,2,2]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics Array Two Pointers Sorting 👍 5711 👎 652

import java.util.Arrays;

public class FourSum18 {
    public static void main(String[] args) {
        Solution solution = new FourSum18().new Solution();
//        int[] nums = new int[]{96, 44, 99, 25, 61, 84, 88, 18, 19, 33, 60, 86, 52, 19, 32, 47, 35, 50, 94, 17, 29, 98, 22, 21, 72, 100, 40, 84};
        int[] nums = new int[]{93, 44, 49, 45, 93, 52, 6, 7, 88, 70, 86, 15, 38, 86, 86, 95, 8, 62, 13, 84, 26, 16, 33, 85, 7, 62, 55, 50, 77, 10, 76, 10, 35, 67, 19, 12, 24, 39, 76, 37};
        long res = solution.minimalKSum(nums, 17);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minimalKSum(int[] nums, int k) {
            Arrays.sort(nums);
            System.out.println(ListNode.toListNode(nums));
            long sum = 0;
            int pre = 0;
            int currK = 0;
            for (int i = 0; i < nums.length; i++) {
                int gap = nums[i] - pre + 1;
                if (gap < 3) {
                    pre = nums[i];
                    continue;
                }
                currK += nums[i] - pre - 1;
                sum += sum(nums[i], pre);
                if (currK == k) {
                    break;
                }
                if (currK > k) {
                    while (currK > k) {
                        int more = nums[i] - currK + k;
                        sum -= more;
                        currK--;
                    }
                    break;
                }
                pre = nums[i];
            }
            if (currK < k) {
                int end = nums[nums.length - 1];
                sum += sum(end + k - currK + 1, end);
            }
            return sum;
        }

        long sum(int i, int j) {
            int gap = i - j + 1;
            return (gap % 2 == 0 ? (long) (i + j) * (gap / 2) :
                    (long) (i + j) * (gap / 2) + (j + gap / 2)) - i - j;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}