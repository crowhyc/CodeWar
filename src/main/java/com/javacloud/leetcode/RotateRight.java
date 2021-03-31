package com.javacloud.leetcode;

public class RotateRight {

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    if (head.next.next == null) {
      if (k % 2 == 0) {
        return head;
      } else {
        head.next.next = head;
        ListNode result = head.next;
        head.next = null;
        return result;
      }
    }
    ListNode headNode = head;
    int length = 1;
    while (head.next != null) {
      head = head.next;
      length++;
    }
    k = k % length;
    for (int i = 1; i <= k; i++) {
      ListNode preTail = headNode.next;
      ListNode tail = headNode.next.next;
      while (tail.next != null) {
        preTail = tail;
        tail = tail.next;
      }
      tail.next = headNode;
      headNode = tail;
      preTail.next = null;
    }
    return headNode;
  }
}
