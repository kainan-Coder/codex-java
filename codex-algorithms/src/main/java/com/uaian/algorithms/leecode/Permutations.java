package com.uaian.algorithms.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        backTrack(nums, lists, list, 0, nums.length);
        return lists;
    }

    private void backTrack(int[] nums, List<List<Integer>> lists, LinkedList<Integer> list, int cur, int length) {
        if(cur == length){
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < length; i++) {
            if(list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            backTrack(nums, lists, list, cur + 1, length);
            list.removeLast();
        }
    }
}
