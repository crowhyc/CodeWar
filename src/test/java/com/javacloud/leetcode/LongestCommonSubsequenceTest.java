package com.javacloud.leetcode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LongestCommonSubsequenceTest {

  @Test
  public void return_LongestCommonSubsequence() {
    LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
    int result = longestCommonSubsequence.longestCommonSubsequence("mhunuzqrkzsnidwbun",
                                                                   "szulspmhwpazoxijwbq");
    assertThat(result, is(6));


  }
}
