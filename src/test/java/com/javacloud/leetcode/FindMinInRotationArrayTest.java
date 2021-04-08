package com.javacloud.leetcode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FindMinInRotationArrayTest {

  @Test
  public void return_FindMin() {
    FindMinInRotationArray rotationArray = new FindMinInRotationArray();
    int[] input = new int[] {4, 3, 2, 1};
    int result = rotationArray.findMin(input);
    assertThat(result, is(1));
  }

  @Test
  public void return_FindMin_0() {
    FindMinInRotationArray rotationArray = new FindMinInRotationArray();
    int[] input = new int[] {5, 1, 2, 3, 4};
    int result = rotationArray.findMin(input);
    assertThat(result, is(1));
  }

  @Test
  public void return_FindMin_2() {
    FindMinInRotationArray rotationArray = new FindMinInRotationArray();
    int[] input = new int[] {4, 5, 6, 7, 0, 1, 2};
    int result = rotationArray.findMin(input);
    assertThat(result, is(0));
  }

  @Test
  public void return_FindMin_3() {
    FindMinInRotationArray rotationArray = new FindMinInRotationArray();
    int[] input = new int[] {0, 1, 2, 3, 4, 5, 6};
    int result = rotationArray.findMin(input);
    assertThat(result, is(0));
  }
}
