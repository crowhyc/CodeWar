package com.javacloud.leetcode;

public class MaxSubArr {
  public int maxSubArray(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int[] subArr = new int[nums.length];
    subArr[0] = nums[0];
    int subArrIdx = 0;
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (result + nums[i] > result) {
        result = result + nums[i];
        subArr[subArrIdx++] = nums[i];
      }else {

      }
    }
    return result;
  }
}
