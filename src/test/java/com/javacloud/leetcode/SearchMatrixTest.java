package com.javacloud.leetcode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SearchMatrixTest {

  @Test
  public void return_SearchMatrix() {
    int[][] input = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    SearchMatrix searchMatrix = new SearchMatrix();
    boolean result = searchMatrix.searchMatrix(input, 13);
    assertThat(result, is(false));
  }

  @Test
  public void return_SearchMatrix_1() {
    int[][] input = {{1, 1}};
    SearchMatrix searchMatrix = new SearchMatrix();
    boolean result = searchMatrix.searchMatrix(input, 2);
    assertThat(result, is(false));
  }

  @Test
  public void return_SearchMatrix_2() {
    int[][] input = {{1}};
    SearchMatrix searchMatrix = new SearchMatrix();
    boolean result = searchMatrix.searchMatrix(input, 1);
    assertThat(result, is(true));
  }
}
