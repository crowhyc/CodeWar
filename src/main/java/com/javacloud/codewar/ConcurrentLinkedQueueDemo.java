package com.javacloud.codewar;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {

  public static void main(String[] args) {
    Queue<String> queue = new ConcurrentLinkedQueue<>();
    queue.offer("test");
    queue.offer("test1");
    queue.offer("test2");
  }
}
