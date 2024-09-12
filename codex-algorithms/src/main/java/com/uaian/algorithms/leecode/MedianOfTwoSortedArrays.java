package com.uaian.algorithms.leecode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m > n)
            return findMedianSortedArrays(nums2, nums1);

        int sumLeft = (m + n + 1) / 2;
        int start = 0, end = m - 1;
        while (start <= end){
            int mid  = (start + end + 1) / 2;
            int sumLeftNums2 = sumLeft - mid;
            if(nums1[mid - 1] > nums2[sumLeftNums2]){
                end = mid - 1;
            }else {
                start = mid;
            }
        }

        int i = start, j = sumLeft - i;

        int nums1Left = i == 0 ? Integer.MIN_VALUE : nums1[i-1];
        int nums1Right = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2Left = j == 0 ? Integer.MIN_VALUE : nums2[j-1];
        int nums2Right = j == n ? Integer.MAX_VALUE : nums2[j];

        if((m + n) % 2 == 0){
            return (double) (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2;
        }else {
            return Math.max(nums1Left, nums1Left);
        }

    }
}
