package com.javacloud.leetcode;

public class Find132Pattern {

  public boolean find132pattern(int[] nums) {
    if (nums.length < 3) {
      return false;
    }
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] < nums[i + 1] && nums[i + 1] > nums[i + 2] && nums[i] < nums[i + 2]) {
        return true;
      }
    }
    return false;
  }
}
