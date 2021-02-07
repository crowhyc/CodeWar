package com.javacloud.stream;

import java.util.stream.Stream;

public class Terminal {

  public void matches() {
    Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    integerStream.allMatch(i -> i > 0); // true
    integerStream.anyMatch(i -> i > 0); // true
    integerStream.noneMatch(i -> i > 0); // false
    Stream<Integer> emptyStream = Stream.<Integer>empty();
    emptyStream.allMatch(i -> i > 0); // true  https://en.wikipedia.org/wiki/Vacuous_truth
    emptyStream.anyMatch(i -> i > 0); // false
    emptyStream.noneMatch(i -> i > 0); // true
  }
}
