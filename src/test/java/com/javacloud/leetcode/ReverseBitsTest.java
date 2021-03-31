package com.javacloud.leetcode;

import org.junit.Test;

public class ReverseBitsTest {

  @Test
  public void return_ReverseBits() {
    int i = 100;
    ReverseBits reverseBits = new ReverseBits();
    int result = reverseBits.reverseBits(i);
    System.out.println(result);
  }
}
