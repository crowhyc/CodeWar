package com.javacloud.leetcode;

import com.javacloud.leetcode.DeleteDuplicatedElements.ListNode;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class DeleteDuplicatedElementsTest {

  @Test
  public void return_Name() {
    int[] arr = {1, 2, 3, 3, 4, 4, 5};
    List<ListNode> nodes = IntStream.of(arr).mapToObj(ListNode::new).collect(Collectors.toList());
    ListNode input = nodes.get(0);
    nodes.stream().reduce((a, b) -> a.next = b);
    ListNode node = new DeleteDuplicatedElements().deleteDuplicates(input);
    printNodes(node);
  }

  @Test
  public void return_Name1() {
    int[] arr = {1, 2, 3, 3};
    List<ListNode> nodes = IntStream.of(arr).mapToObj(ListNode::new).collect(Collectors.toList());
    ListNode input = nodes.get(0);
    nodes.stream().reduce((a, b) -> a.next = b);
    ListNode node = new DeleteDuplicatedElements().deleteDuplicates(input);
    printNodes(node);
  }

  private void printNodes(ListNode node) {
    while (node != null) {
      System.out.println(node.val);
      node = node.next;
    }
  }
}
