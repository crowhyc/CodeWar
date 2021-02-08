package com.javacloud.leetcode;

import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;

public class Sum3Test extends TestCase {

  public void testThreeSum() {
    Sum3 sum3 = new Sum3();
    int[] input = new int[] {-4,-1,-1,0,2,3};

    List<List<Integer>> lists = sum3.threeSum(input);
    System.out.println(Arrays.toString(lists.toArray()));
  }
}