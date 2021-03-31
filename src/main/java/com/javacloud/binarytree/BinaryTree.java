package com.javacloud.binarytree;

public class BinaryTree {
  TreeNode root;

  public BinaryTree(TreeNode root) {
    this.root = root;
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    public TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
