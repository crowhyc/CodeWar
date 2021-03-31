package com.javacloud.leetcode;

import java.math.BigDecimal;

public class AddTwoNumber {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    l1 = reserveListNode(l1);
    l2 = reserveListNode(l2);
    StringBuilder l1Str = new StringBuilder();
    StringBuilder l2Str = new StringBuilder();
    while (l1 != null) {
      l1Str.append(l1.val);
      l1 = l1.next;
    }
    while (l2 != null) {
      l2Str.append(l2.val);
      l2 = l2.next;
    }
    BigDecimal l1Sum = new BigDecimal(l1Str.toString());
    BigDecimal l2Sum = new BigDecimal(l2Str.toString());
    BigDecimal sum = l1Sum.add(l2Sum);
    char[] sumStr = sum.toString().toCharArray();
    ListNode result = null;
    for (char c : sumStr) {
      if (result == null) {
        result = new ListNode(Integer.parseInt(String.valueOf(c)));
      } else {
        result = new ListNode(Integer.parseInt(String.valueOf(c)), result);
      }
    }
    return reserveListNode(result);
  }

  public ListNode addTwoNumberNew(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    boolean buffer = false;
    ListNode result = null;
    ListNode l1Node = reserveListNode(l1);
    ListNode l2Node = reserveListNode(l2);
    while (l1Node != null || l2Node != null) {
      if (l1Node == null) {
        l1Node = new ListNode(0);
      }
      if (l2Node == null) {
        l2Node = new ListNode(0);
      }
      int adding = l1Node.val + l2Node.val;
      if (buffer) {
        adding += 1;
        buffer = false;
      }
      if (adding >= 10) {
        adding -= 10;
        buffer = true;
      }
      result = new ListNode(adding, result);
      l1Node = l1Node.next;
      l2Node = l2Node.next;
    }
    if (buffer) {
      result = new ListNode(1, result);
    }
    return reserveListNode(result);
  }

  private ListNode reserveListNode(ListNode l2) {
    ListNode temp;
    ListNode prev = null;
    while (l2.next != null) {
      temp = l2.next;
      l2.next = prev;
      prev = l2;
      l2 = temp;
    }
    l2.next = prev;
    return l2;
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

    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      ListNode ret = this;
      while (ret.next != null) {
        stringBuilder.append(ret.val);
        ret = ret.next;
      }
      stringBuilder.append(ret.val);
      return stringBuilder.toString();
    }
  }
}
