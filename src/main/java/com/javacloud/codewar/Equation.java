package com.javacloud.codewar;

import java.util.stream.IntStream;

public class Equation {

  public int differentiate(String x, int i) {
    Integer factor =
        IntStream.range(0, x.length())
            .mapToObj(idx -> x.toCharArray()[idx])
            .filter(ret -> !ret.equals("x"))
            .map(Object::toString)
            .map(Integer::parseInt)
            .findFirst()
            .orElse(0);
    return i / factor;
  }
}
