package com.javacloud.leetcode;

public class DeleteDuplicatedElements {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode result = head;
    ListNode tail = head;
    while (head.next != null) {
      if (head.next.val != tail.val) {
        tail.next = head.next;
        tail = tail.next;
      }
      head = head.next;
    }
    tail.next=null;
    return result;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
