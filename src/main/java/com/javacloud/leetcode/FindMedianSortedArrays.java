package com.javacloud.leetcode;

public class FindMedianSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int totalLength = nums1.length + nums2.length;
    if (totalLength % 2 == 1) {
      return getMedianNumber(nums1, nums2, totalLength / 2 + 1);
    } else {
      int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
      return (getMedianNumber(nums1, nums2, midIndex1 + 1)
              + getMedianNumber(nums1, nums2, midIndex2 + 1))
          / 2;
    }
  }

  private double getMedianNumber(int[] nums1, int[] nums2, int k) {

    int i = 0, j = 0;

    while (true) {
      if (i == nums1.length) {
        return nums2[j + k - 1];
      }
      if (j == nums2.length) {
        return nums1[i + k - 1];
      }

      if (k == 1) {
        return Math.min(nums1[i], nums2[j]);
      }
      int half = k / 2;
      int newIndexI = Math.min(i + half, nums1.length) - 1;
      int newIndexJ = Math.min(j + half, nums2.length) - 1;
      if (nums1[newIndexI] <= nums2[newIndexJ]) {
        k = k - (newIndexI - i + 1);
        i = newIndexI + 1;
      } else {
        k = k - (newIndexJ - j + 1);
        j = newIndexJ + 1;
      }
    }
  }

  private double getMedianNumber2(int[] nums1, int[] nums2, int k) {
    int length1 = nums1.length, length2 = nums2.length;
    int index1 = 0, index2 = 0;
    int kthElement = 0;

    while (true) {
      // 边界情况
      if (index1 == length1) {
        return nums2[index2 + k - 1];
      }
      if (index2 == length2) {
        return nums1[index1 + k - 1];
      }
      if (k == 1) {
        return Math.min(nums1[index1], nums2[index2]);
      }

      // 正常情况
      int half = k / 2;
      int newIndex1 = Math.min(index1 + half, length1) - 1;
      int newIndex2 = Math.min(index2 + half, length2) - 1;
      int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
      if (pivot1 <= pivot2) {
        k -= (newIndex1 - index1 + 1);
        index1 = newIndex1 + 1;
      } else {
        k -= (newIndex2 - index2 + 1);
        index2 = newIndex2 + 1;
      }
    }
  }

}
