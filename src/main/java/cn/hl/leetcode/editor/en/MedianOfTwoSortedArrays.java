package cn.hl.leetcode.editor.en;
//Given two sorted arrays nums1 and nums2 of size m and n respectively, return 
//the median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics Array Binary Search Divide and Conquer 👍 14762 👎 1863

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1};
        double res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 对较短的数组进行二分查找
         * 时间复杂度O(log(min(m,n)))
         * 空间复杂度O(1)
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1 == null) {
                return findMedianSortedArrays(new int[0], nums2);
            }
            if (nums2 == null) {
                return findMedianSortedArrays(nums1, new int[0]);
            }
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int m = nums1.length;
            int n = nums2.length;
            int left = 0;
            int right = m;
            // 对较短的数组进行二分查找
            while (left < right) {
                int shortIndex = (left + right) / 2;
                int longerIndex = (m + n) / 2 - shortIndex;
                // 前进条件: shorterRight < longerLeft
                if (nums1[shortIndex] < nums2[longerIndex - 1]) {
                    left = shortIndex + 1;
                } else {
                    right = shortIndex;
                }
            }
            int shorterIndex = left;
            int longerIndex = (m + n) / 2 - shorterIndex;

            int shorterLeft = shorterIndex == 0 ? Integer.MIN_VALUE : nums1[shorterIndex - 1];
            int shorterRight = shorterIndex == m ? Integer.MAX_VALUE : nums1[shorterIndex];
            int longerLeft = longerIndex == 0 ? Integer.MIN_VALUE : nums2[longerIndex - 1];
            int longerRight = longerIndex == n ? Integer.MAX_VALUE : nums2[longerIndex];

            if ((m + n) % 2 == 0) {
                // 为偶数说明需要计算两数平均值
                return Math.max(shorterLeft, longerLeft) * 0.5 + Math.min(shorterRight, longerRight) * 0.5;
            }
            return Math.min(shorterRight, longerRight);
        }

        /**
         * 遍历两个数组逐个放入新数组中
         * 时间复杂度O(m+n)
         * 空间复杂度O(1)
         */
        public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
            if (nums1 == null && nums2 == null) {
                return 0;
            }
            if (nums1 == null || nums1.length == 0) {
                return ((nums2.length - 1) / 2) * 0.5 + ((nums2.length) / 2) * 0.5;
            }
            if (nums2 == null || nums2.length == 0) {
                return ((nums1.length - 1) / 2) * 0.5 + ((nums1.length) / 2) * 0.5;
            }

            int i = 0;
            int j = 0;
            double med1 = 0;
            double med2 = 0;
            while (i + j <= (nums1.length + nums2.length) / 2) {
                med1 = med2;
                if (i >= nums1.length) {
                    // nums1遍历完继续nums2
                    med2 = nums2[j];
                    j++;
                    continue;
                }
                if (j >= nums2.length) {
                    // nums2遍历完继续nums1
                    med2 = nums1[i];
                    i++;
                    continue;
                }
                // 保存较小的一个
                if (nums1[i] < nums2[j]) {
                    med2 = nums1[i];
                    i++;
                } else {
                    med2 = nums2[j];
                    j++;
                }
            }
            if ((nums1.length + nums2.length) % 2 == 0) {
                // 为偶数说明需要计算两数平均值
                return (med1 + med2) / 2;
            }
            return med2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}