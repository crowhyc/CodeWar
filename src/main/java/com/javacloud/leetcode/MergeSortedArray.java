package com.javacloud.leetcode;

public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (m == 0) {
      nums1 = nums2;
    }
    if (n == 0) {
      return;
    }
    int mIdx = 0, nIdx = 0, rIdx = 0;
    int[] result = new int[m + n];
    while (mIdx < m || nIdx < n) {
      int minusVal = 0;
      if (mIdx == m) {
        result[rIdx++] = nums2[nIdx++];
        continue;
      }
      if (nIdx == n) {
        result[rIdx++] = nums1[mIdx++];
        continue;
      }
      if (nums1[mIdx] < nums2[nIdx]) {
        result[rIdx++] = nums1[mIdx++];
      } else {
        result[rIdx++] = nums2[nIdx++];
      }
    }
    nums1 = result;
  }
}
