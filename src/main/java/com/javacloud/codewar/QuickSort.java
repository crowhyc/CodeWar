package com.javacloud.codewar;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.stream.IntStream;

public class QuickSort {

  public static void main(String[] args) {
    List<Integer> arr =
        newArrayList(
            1, 2, 3, 412, 3, 123, 12, 23, 5, 4, 112, 3, 213, 1245, 1234, 23, 323, 41, 23, 6, 6, 7,
            9, 0);
    int[] array = arr.stream().mapToInt(i -> i).toArray();
    quickSort(array, 0, arr.size() - 1);
    IntStream.of(array).forEach(System.out::println);
  }

  private static void quickSort(int[] arr, int head, int tail) {

    if (arr.length <= 1 || head >= tail) {
      return;
    }
    int i = head, j = tail, pivot = arr[(head + tail) / 2];

    while (i <= j) {

      while (arr[i] < pivot) {
        i++;
      }
      while (arr[j] > pivot) {
        j--;
      }
      if (i < j) {
        swap(arr, i, j);
        i++;
        j--;
      } else if (i == j) {
        i++;
      }
    }
    quickSort(arr, head, j);
    quickSort(arr, i, tail);
  }

  private static void swap(int[] arr, int from, int to) {
    int ret = arr[from];
    arr[from] = arr[to];
    arr[to] = ret;
  }
}
