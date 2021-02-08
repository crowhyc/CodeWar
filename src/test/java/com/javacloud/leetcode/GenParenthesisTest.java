package com.javacloud.leetcode;

import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;

public class GenParenthesisTest extends TestCase {

  public void testGenerateParenthesis() {
    GenParenthesis genParenthesis = new GenParenthesis();
    List<String> generateParenthesis = genParenthesis.generateParenthesis(3);
    System.out.println(Arrays.toString(generateParenthesis.toArray()));
  }
}
