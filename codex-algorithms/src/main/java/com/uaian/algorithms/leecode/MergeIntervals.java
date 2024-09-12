package com.uaian.algorithms.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
       merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i+1 < intervals.length && right >= intervals[i+1][0]){
                i++;
                if(right < intervals[i][1]){
                    right = intervals[i][1];
                }
            }
            list.add(new int[]{left, right});
        }

        return list.toArray(new int[list.size()][]);
    }
}
