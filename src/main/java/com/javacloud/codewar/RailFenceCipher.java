package com.javacloud.codewar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RailFenceCipher {

  public static String encode(String src, int rail) {
    if (src == null || src.equals("") || rail < 3) {
      return null;
    }
    String[][] ret = genRailFence(src, rail);
    StringBuilder resultBuilder = new StringBuilder();
    for (String[] retRow : ret) {
      for (String cell : retRow) {
        if (cell != null) {
          System.out.print(cell);
          resultBuilder.append(cell);
        } else {
          System.out.print("□");
        }
      }
      System.out.println();
    }
    return resultBuilder.toString();
  }

  public static String decode(String encode, int rail) {
    String[][] ret = genRailFence(encode, rail);
    char[] srcChars = encode.toCharArray();
    int srcCharIdx = 0;
    for (int i = 0; i < rail; i++) {
      for (int j = 0; j < ret[i].length; j++) {
        if (ret[i][j] != null) {
          ret[i][j] = String.valueOf(srcChars[srcCharIdx++]);
        }
      }
    }
    StringBuilder decodeBuilder = new StringBuilder();
    for (int i = 0; i < ret[0].length; i++) {
      for (int j = 0; j < rail; j++) {
        if (ret[j][i] != null) {
          decodeBuilder.append(ret[j][i]);
        }
      }
    }
    return decodeBuilder.toString();
  }

  private static String[][] genRailFence(String src, int rail) {
    char[] srcChars = src.toCharArray();
    List<String> srcList =
        IntStream.range(0, src.length())
            .mapToObj(i -> srcChars[i])
            .map(String::valueOf)
            .collect(Collectors.toList());
    int row = 0;
    int column = 0;
    boolean isDown = true;
    String[][] ret = new String[rail][src.length()];
    for (String s : srcList) {
      ret[row][column++] = s;
      if (isDown) {
        row++;
        if (row == rail - 1) {
          isDown = false;
        }
      } else {
        row--;
        if (row == 0) {
          isDown = true;
        }
      }
    }
    return ret;
  }
}
