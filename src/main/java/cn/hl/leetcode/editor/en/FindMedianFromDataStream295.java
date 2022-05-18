package cn.hl.leetcode.editor.en;
//The median is the middle value in an ordered integer list. If the size of the 
//list is even, there is no middle value and the median is the mean of the two 
//middle values. 
//
// 
// For example, for arr = [2,3,4], the median is 3. 
// For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5. 
// 
//
// Implement the MedianFinder class: 
//
// 
// MedianFinder() initializes the MedianFinder object. 
// void addNum(int num) adds the integer num from the data stream to the data 
//structure. 
// double findMedian() returns the median of all elements so far. Answers 
//within 10⁻⁵ of the actual answer will be accepted. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//Output
//[null, null, null, 1.5, null, 2.0]
//
//Explanation
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0
// 
//
// 
// Constraints: 
//
// 
// -10⁵ <= num <= 10⁵ 
// There will be at least one element in the data structure before calling 
//findMedian. 
// At most 5 * 10⁴ calls will be made to addNum and findMedian. 
// 
//
// 
// Follow up: 
//
// 
// If all integer numbers from the stream are in the range [0, 100], how would 
//you optimize your solution? 
// If 99% of all integer numbers from the stream are in the range [0, 100], how 
//would you optimize your solution? 
// 
// Related Topics Two Pointers Design Sorting Heap (Priority Queue) Data Stream 
//👍 6463 👎 122

import java.util.Arrays;
import java.util.LinkedHashMap;

public class FindMedianFromDataStream295 {
    public static void main(String[] args) {
        MedianFinder solution = new FindMedianFromDataStream295().new MedianFinder();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.keySet().iterator().next();
        System.out.println(32 << 1);
        for (int i = 0; i < 50; i++) {
            solution.addNum(i);
            double median = solution.findMedian();
            System.out.println(median);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        private int[] arr;

        private int size;

        private void resize() {
            if (size < arr.length) {
                return;
            }
            int oldCap = arr.length;
            arr = Arrays.copyOf(arr, oldCap << 1);
        }

        public MedianFinder() {
            arr = new int[32];
            size = 0;
        }

        /**
         * TC=O(N)
         */
        public void addNum(int num) {
            int pos = -1;
            for (int i = 0; i < size; i++) {
                if (arr[i] >= num) {
                    pos = i;
                    break;
                }
            }
            if (pos == -1) {
                // add to tail
                arr[size] = num;
            } else {
                for (int i = size - 1; i >= pos; i--) {
                    arr[i + 1] = arr[i];
                }
                arr[pos] = num;
            }
            size++;
            resize();
        }

        /**
         * TC=O(1)
         */
        public double findMedian() {
            if (size == 0) {
                return 0;
            }
            if (size % 2 == 0) {
                return arr[size / 2] * 0.5 + arr[size / 2 - 1] * 0.5;
            } else {
                return (double) arr[size / 2];
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}