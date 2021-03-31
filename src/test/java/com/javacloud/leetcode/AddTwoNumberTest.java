package com.javacloud.leetcode;

import com.javacloud.leetcode.AddTwoNumber.ListNode;
import org.junit.Test;

public class AddTwoNumberTest {

  @Test
  public void testAddTwoNumberTest() {
    AddTwoNumber.ListNode l1 = new ListNode(9);
    l1 = new ListNode(4, l1);
    l1 = new ListNode(2, l1);
    ListNode l2 = new ListNode(9);
    l2 = new ListNode(4, l2);
    l2 = new ListNode(6, l2);
    l2 = new ListNode(5, l2);

    AddTwoNumber addTwoNumber = new AddTwoNumber();
    ListNode listNode = addTwoNumber.addTwoNumberNew(l1, l2);
    System.out.println(listNode);
  }

  @Test
  public void testAddTwoNumberTest_with_one_null_ListNode() {
    AddTwoNumber.ListNode l1 = null;
    ListNode l2 = new ListNode(4);
    l2 = new ListNode(6, l2);
    l2 = new ListNode(5, l2);

    AddTwoNumber addTwoNumber = new AddTwoNumber();
    ListNode listNode = addTwoNumber.addTwoNumbers(l1, l2);
    System.out.println(listNode);
  }

  @Test
  public void testAddTwoNumberTest_with_different_length_ListNode() {
    AddTwoNumber.ListNode l1 = new ListNode(3);
    l1 = new ListNode(4, l1);
    l1 = new ListNode(2, l1);
    l1 = new ListNode(1, l1);
    ListNode l2 = new ListNode(4);
    l2 = new ListNode(6, l2);
    l2 = new ListNode(5, l2);

    AddTwoNumber addTwoNumber = new AddTwoNumber();
    ListNode listNode = addTwoNumber.addTwoNumberNew(l1, l2);
    System.out.println(listNode);
  }
}
