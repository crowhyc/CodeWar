package com.javacloud.leetcode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class find132PatternTest {

  @Test
  public void return_Find132pattern() {
    Find132Pattern find132Pattern = new Find132Pattern();
    //    int[] input = {1, 3, 2, 4};
    //    assertThat(find132Pattern.find132pattern(input), is(true));
    //    int[] input1 = {1, 3};
    //    assertThat(find132Pattern.find132pattern(input1), is(false));
    int[] input2 = {3, 5, 0, 3, 4};
    assertThat(find132Pattern.find132pattern(input2), is(true));
  }
}
