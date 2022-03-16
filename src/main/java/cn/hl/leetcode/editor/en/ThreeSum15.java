package cn.hl.leetcode.editor.en;
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[
//k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics Array Two Pointers Sorting 👍 16234 👎 1553

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public static void main(String[] args) {
        Solution solution = new ThreeSum15().new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        List<List<Integer>> res = solution.threeSum(nums);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            // 先排序
            Arrays.sort(nums);
            return nSum(nums, 3, 0, 0);
        }

        /**
         * 先对数组排序O(NlogN)
         * 再用左右指针查找结果O(logN)
         * base case为求2数和,>2时递归求解
         */
        List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
            int size = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (size < n || n < 2) {
                return res;
            }
            // base case
            if (n == 2) {
                // 双指针查找
                int lo = start, hi = size - 1;
                while (lo < hi) {
                    int left = nums[lo];
                    int right = nums[hi];
                    int sum = left + right;
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(left);
                        list.add(right);
                        res.add(list);
                        // 跳过重复数字
                        while (lo < hi && nums[lo] == left) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == right) {
                            hi--;
                        }
                    }
                    if (sum > target) {
                        // 跳过重复数字
                        while (lo < hi && nums[hi] == right) {
                            hi--;
                        }
                    }
                    if (sum < target) {
                        // 跳过重复数字
                        while (lo < hi && nums[lo] == left) {
                            lo++;
                        }
                    }
                }
            } else {
                for (int i = start; i < nums.length; i++) {
                    int newTarget = target - nums[i];
                    // n数之和=n-1数之和+当前数
                    List<List<Integer>> arr = nSum(nums, n - 1, i + 1, newTarget);
                    for (List<Integer> a : arr) {
                        if (!a.isEmpty()) {
                            a.add(nums[i]);
                            res.add(a);
                        }
                    }
                    // 跳过第一个数字重复的情况，否则会出现重复结果
                    while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                        i++;
                    }
                }
            }

            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}