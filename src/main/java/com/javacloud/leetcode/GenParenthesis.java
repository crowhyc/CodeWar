package com.javacloud.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenParenthesis {

  public static final String left = "(";
  public static final String right = ")";

  public List<String> generateParenthesis(int n) {
    if (n == 0 || n > 8) {
      return Collections.emptyList();
    }
    List<String> result = new ArrayList<>();
    generate(result, new StringBuilder(), 0, 0, n);
    return result;
  }

  private void generate(
      List<String> result, StringBuilder rat, int openCnt, int closeCnt, int max) {
    if (rat.length() == max * 2) {
      result.add(rat.toString());
      return;
    }

    if (openCnt < max) {
      rat.append(left);
      generate(result, rat, openCnt + 1, closeCnt, max);
      rat.deleteCharAt(rat.length() - 1);
    }
    if (closeCnt < openCnt) {
      rat.append(right);
      generate(result, rat, openCnt, closeCnt + 1, max);
      rat.deleteCharAt(rat.length() - 1);
    }
  }

  private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
    if (cur.length() == max * 2) {
      ans.add(cur.toString());
      return;
    }
    if (open < max) {
      cur.append('(');
      backtrack(ans, cur, open + 1, close, max);
      cur.deleteCharAt(cur.length() - 1);
    }
    if (close < open) {
      cur.append(')');
      backtrack(ans, cur, open, close + 1, max);
      cur.deleteCharAt(cur.length() - 1);
    }
  }
}
