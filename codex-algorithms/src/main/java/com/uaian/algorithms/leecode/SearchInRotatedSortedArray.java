package com.uaian.algorithms.leecode;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int len = nums.length;
        int start = 0, end = len - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] >= nums[start]) {
                if(target >= nums[start] && nums[mid] > target){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else {
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
