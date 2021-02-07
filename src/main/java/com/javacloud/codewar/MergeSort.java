package com.javacloud.codewar;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSort {
  public static void main(String[] args) {
    List<Integer> arr =
        newArrayList(
            1, 2, 3, 412, 3, 123, 12, 23, 5, 4, 112, 3, 213, 1245, 1234, 23, 323, 41, 23, 6, 6, 7,
            9, 0);
    System.out.println(mergeSort(arr));
  }

  static List<Integer> mergeSort(List<Integer> arr) {
    int len = arr.size();
    if (len < 2) {
      return arr;
    }
    int middlePoint = len / 2;

    List<Integer> leftArr = arr.subList(0, middlePoint);
    List<Integer> rightArr = arr.subList(middlePoint, len);

    return mergeArr(mergeSort(leftArr), mergeSort(rightArr));
  }

  private static List<Integer> mergeArr(List<Integer> left, List<Integer> right) {
    System.out.println(left);
    System.out.println(right);
    return Stream.of(left, right).flatMap(Collection::stream).sorted().collect(Collectors.toList());
  }
}
