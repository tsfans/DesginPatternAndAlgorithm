/**
 * Copyright (C) 2020 ~ 2022 Meituan. All Rights Reserved.
 */
package cn.hl.algorithm.sort;

import cn.hl.leetcode.editor.en.ListNode;

/**
 * @author:   		HuLin
 * @date:    		2022年2月11日 上午11:42:02
 * @description:    堆排序,时间复杂度O(nlogn),空间复杂度O(1)
 * @version:   		v1.0
 */
public class HeapSort {

    /**
     * 获取父节点索引
     */
    private static int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * 获取左子节点索引（可能越界,注意判断）
     */
    private static int left(int i) {
        return i * 2 + 1;
    }

    /**
     * 获取右子节点索引（可能越界,注意判断）
     */
    private static int right(int i) {
        return left(i) + 1;
    }

    /**
     * 构建最大堆,从最后一个有子节点的节点开始
     */
    private static void buildMaxHeap(int[] arr) {
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }

    /**
     * 维护最大堆结构
     */
    private static void maxHeapify(int[] arr, int target, int heapSize) {
        // 存在左子节点
        while (left(target) <= heapSize - 1) {
            int child = left(target);
            int right = right(target);
            if (right <= heapSize - 1 && arr[child] < arr[right]) {
                // 右子节点也存在的话取大的一个
                child++;
            }
            if (arr[target] >= arr[child]) {
                // 已经比最大子节点大,终止循环
                break;
            }
            // 否则交换父子节点位置
            swap(arr, target, child);
            target = child;
        }
    }

    /**
     * 交换数组中的两个元素
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 堆排序
     */
    public static void doHeapSort(int[] arr) {
        // 构建最大堆
        buildMaxHeap(arr);

        /**
         * 此时堆顶为最大值,逐个将堆顶元素移到数组末尾,即可完成数组排序
         */
        int max = arr.length - 1;
        while (max > 0) {
            swap(arr, 0, max);
            maxHeapify(arr, 0, max);
            max--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 4, 1, 21, 12, 22, 4, 21 };
        doHeapSort(arr);
        System.out.println(ListNode.toString(arr));
    }

}
