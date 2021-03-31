package com.javacloud.binarytree;

import static org.junit.Assert.assertEquals;

import com.javacloud.binarytree.BinaryTree.TreeNode;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class PreorderTraversalTest {

  private BinaryTree tree;

  @Before
  public void pred() {
    new TreeNode(1);
    TreeNode root = new TreeNode(1);
    TreeNode l1 = new TreeNode(2);
    TreeNode l1l1 = new TreeNode(3);

    root.right = null;
    root.left = l1;
    l1.left = l1l1;
    tree = new BinaryTree(root);
  }

  @Test
  public void testTraversalUseRecursion() {
    String result = Arrays.toString(PreorderTraversal.traversalUseRecursion(tree.root).toArray());

    assertEquals("rootabBAcdDC", result);
  }

  @Test
  public void testTraversalNormal() {
    String result = Arrays.toString(PreorderTraversal.traversalNormal(tree.root).toArray());
    assertEquals("rootabBAcdDC", result);
  }
}
