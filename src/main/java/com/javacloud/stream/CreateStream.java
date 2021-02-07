package com.javacloud.stream;

import static com.google.common.collect.Lists.newArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class CreateStream {

  public void createCollectionStream() {
    ArrayList<Integer> collection = newArrayList(1, 2, 3, 4, 5);
    collection.stream();
    collection.parallelStream();
    Arrays.asList(collection).stream();
    Arrays.asList(collection).stream();
  }

  public void createIntStream() {

    IntStream.of(1, 2, 3, 4); // 1,2,3,4
    IntStream.of(4); // 0,1,2,3
    IntStream.range(5, 10); // 5,6,7,8,9
    IntStream.rangeClosed(5, 10); // 5,6,7,8,9,10
    IntStream.concat(IntStream.of(1, 2, 3, 4), IntStream.of(5, 6, 7, 8)); // 1,2,3,4,5,6,7,8
  }

  public void createLongStream() {

    LongStream.of(1, 2, 3, 4); // 1,2,3,4
    LongStream.of(4); // 0,1,2,3
    LongStream.range(5, 10); // 5,6,7,8,9
    LongStream.rangeClosed(5, 10); // 5,6,7,8,9,10
    LongStream.concat(LongStream.of(1, 2, 3, 4), LongStream.of(5, 6, 7, 8)); // 1,2,3,4,5,6,7,8
  }

  public void createDoubleStream() {

    DoubleStream.of(1, 2, 3, 4); // 1,2,3,4
    DoubleStream.of(4); // 0,1,2,3
    DoubleStream.concat(
        DoubleStream.of(1, 2, 3, 4), DoubleStream.of(5, 6, 7, 8)); // 1,2,3,4,5,6,7,8
  }
}
