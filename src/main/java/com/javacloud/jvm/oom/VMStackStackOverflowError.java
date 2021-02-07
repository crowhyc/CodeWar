package com.javacloud.jvm.oom;
//  -Xss128k
public class VMStackStackOverflowError {
  private int stackLength = -1;

  public void stackLeak() {
    stackLength++;
    stackLeak();
  }

  public static void main(String[] args) {
    VMStackStackOverflowError error = new VMStackStackOverflowError();
    try {
      error.stackLeak();
    } catch (Throwable e) {
      System.out.println("stack length:" + error.stackLength);
      e.printStackTrace();
    }
  }
}
