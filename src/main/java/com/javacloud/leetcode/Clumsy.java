package com.javacloud.leetcode;

public class Clumsy {
  public int clumsy(int N) {
    int sum = 0;
    int signal = -1;
    for (int i = N; i > 0; i -= 4) {
      int count = i;
      if (i - 1 == 0) {
        return sum  - (count * signal);
      } else {
        count = i * (i - 1);
      }
      if (i - 2 == 0) {
        return sum  - (count * signal);
      } else {
        count /= (i - 2);
      }
      if (i - 3 == 0) {
        return sum  - (count * signal);
      } else {
        sum += (i - 3);
      }
      sum = sum - (count * signal);
      if (signal < 0) {
        signal = 1;
      }
    }

    return sum ;
  }
}
