package myutils.sorting;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * Idea: ...
 */


public class SelectionSort {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr1 = Arrays.copyOf(nums1, m);
        int[] arr2 = Arrays.copyOf(nums2, n);

        int i=0, j=0, k=0;
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                nums1[k++] = arr1[i++];
            }
            else {
                nums1[k++] = arr2[j++];
            }
        }
        while (i < m) {
            nums1[k++] = arr1[i++];
        }
        while (j < n) {
            nums1[k++] = arr2[j++];
        }
    }
}
