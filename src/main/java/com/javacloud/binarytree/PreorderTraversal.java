package com.javacloud.binarytree;

import com.javacloud.binarytree.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

  public static List<Integer> traversalUseRecursion(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    result.add(root.val);
    result.addAll(traversalUseRecursion(root.right));
    result.addAll(traversalUseRecursion(root.left));
    return result;
  }

  public static List<Integer> traversalNormal(TreeNode node) {
    if(node==null){
      return Collections.emptyList();
    }
    Stack<TreeNode> nodeStack = new Stack<>();
    List<Integer> nodeVals = new ArrayList<>();
    nodeStack.push(node);
    while (!nodeStack.isEmpty()) {
      TreeNode treeNode = nodeStack.pop();
      nodeVals.add(treeNode.val);
      if (treeNode.right != null) {
        nodeStack.push(treeNode.right);
      }
      if (treeNode.left != null) {
        nodeStack.push(treeNode.left);
      }
    }
    return nodeVals;
  }
}
