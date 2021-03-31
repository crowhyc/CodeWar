package com.javacloud.binarytree;

import com.javacloud.binarytree.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

  public static List<Integer> traversalUseRecursion(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    result.addAll(traversalUseRecursion(root.right));
    result.addAll(traversalUseRecursion(root.left));
    result.add(root.val);
    return result;
  }

  public static List<Integer> traversalNormal(TreeNode root) {
    Stack<TreeNode> nodeStack = new Stack<>();
    List<Integer> nodeVals = new ArrayList<>();
    TreeNode preNode = null;
    while (root != null || !nodeStack.isEmpty()) {
      while (root != null) {
        nodeStack.push(root);
        root = root.left;
      }
      root = nodeStack.pop();
      if (root.right == null || root.right == preNode) {
        nodeVals.add(root.val);
        preNode = root;
        root = null;
      } else {
        nodeStack.push(root);
        root = root.right;
      }
    }

    return nodeVals;
  }
}
