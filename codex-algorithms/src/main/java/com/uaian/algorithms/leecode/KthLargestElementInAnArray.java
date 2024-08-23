package com.uaian.algorithms.leecode;

import java.util.Random;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestByQuickSort(nums, 0, nums.length - 1, k);
    }

    private int findKthLargestByQuickSort(int[] nums, int start, int end, int k) {
        int i, j, standard;
        if(start >= end)
            return nums[start];

        i = start;
        j = end;
        randomStandardNum(nums, i, j);
        standard = nums[i];

        while (i < j){
            while (i < j && nums[j] >= standard){
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= standard){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = standard;
        if(k == nums.length - i){
            return nums[i];
        }else if(k > nums.length - i){
            return findKthLargestByQuickSort(nums, start, i - 1, k);
        }else {
            return findKthLargestByQuickSort(nums, i + 1, end, k);
        }
    }

    private void randomStandardNum(int[] nums, int i, int j) {
        int random = i + new Random().nextInt(j - i);
        int tmp = nums[random];
        nums[random] = nums[i];
        nums[i] = tmp;
    }
}
