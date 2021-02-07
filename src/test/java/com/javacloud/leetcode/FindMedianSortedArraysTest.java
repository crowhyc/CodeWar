package com.javacloud.leetcode;

import junit.framework.TestCase;

public class FindMedianSortedArraysTest extends TestCase {

  public void testFindMedianSortedArrays() {

    FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();

    int[] arr1 = new int[]{0,0,0,0,0};

    int[] arr2 = new int[] {};

    double sortedArrays = findMedianSortedArrays.findMedianSortedArrays(arr1, arr2);
    assertEquals(sortedArrays, 0);
  }
}
