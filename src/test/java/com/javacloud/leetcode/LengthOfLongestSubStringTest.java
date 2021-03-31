package com.javacloud.leetcode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LengthOfLongestSubStringTest {

  @Test
  public void return_Name() {
    String tgt = "abcabcbb";

    int result = new LengthOfLongestSubString().lengthOfLongestSubstring(tgt);
    assertThat(result, is(3));
  }

  @Test
  public void return_1_when_input_str_all_b() {
    String tgt = "au";

    int result = new LengthOfLongestSubString().lengthOfLongestSubstring(tgt);
    assertThat(result, is(2));
  }
}
