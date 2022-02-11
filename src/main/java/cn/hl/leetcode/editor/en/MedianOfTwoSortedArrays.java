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

public class MedianOfTwoSortedArrays{
      public static void main(String[] args) {
           Solution solution = new MedianOfTwoSortedArrays().new Solution();
           int[] nums1 = new int[]{1,3,5};
           int[] nums2 = new int[]{};
          double res = solution.findMedianSortedArrays(nums1, nums2);
          System.out.println(res);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenght = nums1.length + nums2.length;
        if(lenght == 0){
            return 0;
        }
        boolean two = lenght % 2 == 0 ? true : false;
        int mid = lenght / 2;
        int[] array = new int[mid + 1];
        int i = 0;
        int j = 0;
        while(i + j <= mid){
            if(i >= nums1.length){
                array[i+j] = nums2[j];
                j++;
                continue;
            }
            if(j >= nums2.length){
                array[i+j] = nums1[i];
                i++;
                continue;
            }
            if(nums1[i] < nums2[j]){
                array[i+j] = nums1[i];
                i++;
            }
            else {
                array[i+j] = nums2[j];
                j++;
            }
        }
        if(two){
            return (Double.valueOf(array[mid - 1]) + Double.valueOf(array[mid] )) / 2;
        }
        return array[mid];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }