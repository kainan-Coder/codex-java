package com.uaian.algorithms.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums.length == 0)
            return lists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int target = -nums[i];
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                if(nums[start] + nums[end]== target){
                    lists.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start] == nums[start + 1]){
                        start++;
                    }
                    start++;
                    while (start < end && nums[end] == nums[end - 1]){
                        end--;
                    }
                    end--;
                } else if (nums[start] + nums[end] > target) {
                    end--;
                }else {
                    start++;
                }
            }
        }
        return lists;
    }
}
