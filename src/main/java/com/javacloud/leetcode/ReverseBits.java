package com.javacloud.leetcode;

public class ReverseBits {
  public int reverseBits(int n) {
    String needConvertStr = Long.toBinaryString(n);
    StringBuilder stringBuilder = new StringBuilder();
    char[] charArray = needConvertStr.toCharArray();
    for (int i = 0; i < 32; i++) {
      if (i < charArray.length) {
        stringBuilder.append(charArray[charArray.length - i - 1]);
      } else {
        stringBuilder.append("0");
      }
    }
    return Long.valueOf(stringBuilder.toString(), 2).intValue();
  }
}
