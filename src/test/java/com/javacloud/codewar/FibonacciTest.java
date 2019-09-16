package com.javacloud.codewar;

import java.math.BigInteger;
import org.junit.Test;

public class FibonacciTest {

  @Test
  public void test2000000() {
    long start = System.currentTimeMillis();
    fib(BigInteger.valueOf(1_249_305));
    System.out.println("total use time is :" + (System.currentTimeMillis() - start));
  }

  private BigInteger fib(BigInteger times) {
    if (times.equals(BigInteger.ZERO)) {
      return BigInteger.ZERO;
    }
    BigInteger nowVal;
    BigInteger formerVal = BigInteger.ZERO;
    if (times.compareTo(BigInteger.ZERO) > 0) {
      nowVal = BigInteger.ONE;
    } else {
      nowVal = BigInteger.valueOf(-1);
    }
    long value = times.abs().intValue();
    for (long i = 0; i < value - 1; i++) {
      BigInteger ret = nowVal.add(formerVal);
      formerVal = nowVal;
      nowVal = ret;
      System.out.println("nowVal is : " + nowVal.toString());
    }
    return nowVal;
  }
}
