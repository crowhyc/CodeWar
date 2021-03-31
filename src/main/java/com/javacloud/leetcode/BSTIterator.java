package com.javacloud.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator {

  private List<TreeNode> nodes;
  private int nowIdx = 0;

  public BSTIterator(TreeNode root) {
    nodes = middleTravelTree(root);
  }

  private List<TreeNode> middleTravelTree(TreeNode node) {
    if (node == null) {
      return new ArrayList<>();
    }
    List<TreeNode> result = new ArrayList<>();

    Stack<TreeNode> nodeStack = new Stack<>();
    nodeStack.push(node);
    while (node != null || !nodeStack.isEmpty()) {
      while (node != null) {
        nodeStack.push(node);
        node = node.left;
      }
      node = nodeStack.pop();
      result.add(node);
      node = node.right;
    }
    return result;
  }

  public int next() {
    if (!hasNext()) {
      return -1;
    } else {
      return nodes.get(nowIdx++).val;
    }
  }

  public boolean hasNext() {
    return nodes.size() - 1 >= nowIdx;
  }
}
