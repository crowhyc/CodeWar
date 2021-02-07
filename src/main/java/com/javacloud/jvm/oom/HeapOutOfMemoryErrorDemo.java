package com.javacloud.jvm.oom;

import java.util.ArrayList;
import java.util.List;
//-verbose:gc -Xms20M -Xmx20M  -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/yicai.huang/jvm/dump/
public class HeapOutOfMemoryErrorDemo {
  static class OOMObject {}

  public static void main(String[] args) {
    List<OOMObject> list = new ArrayList<>();
    while (true) {
      list.add(new OOMObject());
    }
  }
}
