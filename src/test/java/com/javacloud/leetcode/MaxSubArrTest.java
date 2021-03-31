package com.javacloud.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

public class MaxSubArrTest extends TestCase {

  @Test
  public void test() {
    MaxSubArr maxSubArr = new MaxSubArr();
    int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int result = maxSubArr.maxSubArray(input);
    assertEquals(result, 6);
  }
}
