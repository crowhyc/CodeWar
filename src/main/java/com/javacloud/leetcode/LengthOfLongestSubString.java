package com.javacloud.leetcode;

public class LengthOfLongestSubString {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }

    int startIdx = 0;
    int endIdx = 0;
    int longest = 1;
    char[] array = s.toCharArray();
    for (int i = 1; i < array.length; i++) {
    longest=  Math.max(longest, endIdx - startIdx + 1);
      for (int j = startIdx; j <= endIdx; j++) {
        if (array[j] == array[i]) {
          startIdx = j + 1;
          break;
        }
      }
      endIdx++;
    }
    return Math.max(longest, endIdx - startIdx + 1);
  }
}
