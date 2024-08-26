package com.uaian.algorithms.sort;

import java.util.Random;

public class QuickSort implements ISort{
    @Override
    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int i, int j) {
        int start, end, standard;
        if(i >= j)
            return;
        start = i;
        end = j;
        randomStart(nums, i, j);
        standard = nums[i];
        while (start < end){
            while (start < end && nums[end] >= standard){
                end--;
            }
            nums[end] = nums[start];
            while (start < end && nums[start] <= standard){
                start++;
            }
            nums[start] = nums[end];
        }
        nums[start] = standard;
        quickSort(nums, i, start - 1);
        quickSort(nums, start + 1, j);
    }

    private void randomStart(int[] nums, int i, int j) {
        int index = i + new Random().nextInt(j - i);
        int tmp = nums[index];
        nums[index] = nums[i];
        nums[i] = tmp;
    }
}
