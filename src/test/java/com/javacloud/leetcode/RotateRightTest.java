package com.javacloud.leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class RotateRightTest {

  @Test
  public void return_RotateRight() {
    int[] arr = {0, 1, 2};
    List<ListNode> nodes = IntStream.of(arr).mapToObj(ListNode::new).collect(Collectors.toList());
    ListNode input = nodes.get(0);
    nodes.stream().reduce((a, b) -> a.next = b);
    RotateRight rotateRight = new RotateRight();
    rotateRight.rotateRight(input, 4);
  }
}
