package com.javacloud.jvm.oom;

// -Xss2M
public class CreateThreadStackOOM {
  private void dontStop() {
    while (true) {}
  }

  public void stackLeakByThread() {
    while (true) {
      Thread t = new Thread(() -> dontStop());
      t.start();
    }
  }

  public static void main(String[] args) {
    CreateThreadStackOOM oom = new CreateThreadStackOOM();
    oom.stackLeakByThread();
  }
}
