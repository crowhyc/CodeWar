package com.javacloud.leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
  private final Stack<Integer> dataStack = new Stack<>();

  public NestedIterator(List<NestedInteger> nestedList) {
    Stack<Integer> stack = new Stack<>();
    pushNestedInteger(nestedList, stack);
    while (!stack.isEmpty()) {
      dataStack.push(stack.pop());
    }
  }

  @Override
  public boolean hasNext() {
    return !dataStack.isEmpty();
  }

  @Override
  public Integer next() {
    if (dataStack.isEmpty()) {
      return null;
    }
    return dataStack.pop();
  }

  private void pushNestedInteger(List<NestedInteger> nestedList, Stack<Integer> stack) {
    for (NestedInteger n : nestedList) {
      if (n.isInteger()) {
        stack.push(n.getInteger());
      } else {
        pushNestedInteger(n.getList(), stack);
      }
    }
  }

  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }
}
