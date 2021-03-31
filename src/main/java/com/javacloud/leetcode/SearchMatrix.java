package com.javacloud.leetcode;

public class SearchMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int arr = matrix[0].length - 1, col = 0;
    while (arr >= 0 && col < matrix.length) {
      System.out.println("col:" + col + " arr:" + arr);
      int result = matrix[col][arr];
      if (result == target) {
        return true;
      }
      if (result < target) {
        ++col;
      }
      if (result > target) {
        --arr;
      }
    }
    return false;
  }
}
