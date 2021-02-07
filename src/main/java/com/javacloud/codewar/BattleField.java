package com.javacloud.codewar;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BattleField {

  public boolean fieldValidator(int[][] fields) {
    if (fields.length != 10) {
      return false;
    }
    long fieldsWidth = Arrays.stream(fields, 0, 10).filter(field -> field.length == 10).count();
    if (fieldsWidth != 10) {
      return false;
    }
    int[][] verticalFields =
        (int[][])
            IntStream.range(0, 10)
                .mapToObj(idx -> IntStream.range(0, 10).map(jdx -> fields[jdx][idx]).toArray())
                .toArray();
    Stream.concat(Arrays.stream(fields), Arrays.stream(verticalFields))
        .map(this::convertIntArrayToBinary)
        .forEach(System.out::println);
    return true;
  }

  public int convertIntArrayToBinary(int[] intArray) {
    return IntStream.range(0, intArray.length)
        .map(
            idx -> {
              if (intArray[idx] == 1) {
                return 1 << idx;
              }
              return 0;
            })
        .reduce((binary, ret) -> binary |= ret)
        .getAsInt();
  }
}
