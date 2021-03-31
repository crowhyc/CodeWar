package com.javacloud.binarytree;

import com.javacloud.binarytree.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MidorderTraversal {

  public static List<Integer> traversalUseRecursion(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    result.addAll(traversalUseRecursion(root.right));
    result.add(root.val);
    result.addAll(traversalUseRecursion(root.left));
    return result;
  }

  public static List<Integer> traversalNormal(TreeNode node) {
    Stack<TreeNode> nodeStack = new Stack<>();
    List<Integer> nodeVals = new ArrayList<>();
    while (node != null || !nodeStack.isEmpty()) {
      while (node != null) {
        nodeStack.push(node);
        node = node.left;
      }
      node = nodeStack.pop();
      nodeVals.add(node.val);
      node = node.right;
    }

    return nodeVals;
  }
}
