package cn.hl.leetcode.editor.en;
//Given n non-negative integers representing an elevation map where the width 
//of each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
//
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) 
//are being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack ?
//? 17046 👎 243

public class TrappingRainWater42 {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater42().new Solution();
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = solution.trap(nums);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * water[i]=min(max(left), max(right)) - height[i];
         */
        public int trap(int[] height) {
            if (height == null || height.length < 3) {
                return 0;
            }
            int water = 0;
            for (int i = 0; i < height.length; i++) {
                water += water(height, i);
            }
            return water;
        }

        int water(int[] height, int i) {
            if (i == 0 || i == height.length - 1) {
                return 0;
            }
            int maxLeft = max(height, 0, i - 1);
            int maxRight = max(height, i + 1, height.length - 1);
            return Math.min(maxLeft, maxRight) - height[i];
        }

        int max(int[] height, int start, int end) {
            int max = 0;
            for (int i = start; i <= end; i++) {
                max = Math.max(max, height[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}