package com.javacloud.leetcode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ClumsyTest {

  @Test
  public void return_Clumsy() {
    Clumsy clumsy = new Clumsy();
    int result = clumsy.clumsy(5);
    assertThat(result, is(7));
  }
}
