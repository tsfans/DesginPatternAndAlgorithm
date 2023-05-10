package cn.hl.leetcode.editor.en;
//There is an integer array nums sorted in ascending order (with distinct 
//values). 
//
// Prior to being passed to your function, nums is possibly rotated at an 
//unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k]
//, nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
//example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0
//,1,2]. 
//
// Given the array nums after the possible rotation and an integer target, 
//return the index of target if it is in nums, or -1 if it is not in nums. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// Example 2: 
// Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
// Example 3: 
// Input: nums = [1], target = 0
//Output: -1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -10⁴ <= nums[i] <= 10⁴ 
// All values of nums are unique. 
// nums is an ascending array that is possibly rotated. 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics Array Binary Search 👍 13006 👎 851

public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray33().new Solution();
        int[] nums = new int[]{5, 1, 2, 3, 4};
        int res = solution.search(nums, 7);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int lo = 0, hi = nums.length - 1;
            while (lo <= hi) {
                int mid = lo + ((hi - lo) >> 1);
                // 判断是否旋转过
                boolean rotated = nums[lo] > nums[hi];
                if (nums[mid] > target) {
                    if (rotated && nums[mid] > nums[hi] && nums[hi] >= target) {
                        // 如果旋转过且落在左半区且右半区最大值>=target,那么查找右半区
                        lo = mid + 1;
                    } else {
                        // 否则查找左半区
                        hi = mid - 1;
                    }
                } else if (nums[mid] < target) {
                    if (rotated && nums[mid] < nums[hi] && nums[hi] < target) {
                        // 如果旋转过且落在右半区且右半区最大值<target,那么查找左半区
                        hi = mid - 1;
                    } else {
                        // 否则查找左半区
                        lo = mid + 1;
                    }
                } else {
                    // 相等返回结果
                    return mid;
                }
            }
            // 找不到返回-1
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}