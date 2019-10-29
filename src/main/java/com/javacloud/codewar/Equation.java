package com.javacloud.codewar;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Equation {

  public static BigInteger differentiate(String equation, long x) {
    System.out.println("equation is " + equation + " x is " + x);
    StringBuffer tempStrBuffer = new StringBuffer();
    EquationBuffer equationBuffer = new EquationBuffer(x);
    IntStream.range(0, equation.length())
        .mapToObj(idx -> equation.toCharArray()[idx])
        .forEach(
            character -> {
              if (character == '+') {
                equationBuffer.appendNumAndClearBuffer(tempStrBuffer);
                equationBuffer.setNextPlus(true);
              } else if (character == '-') {
                equationBuffer.appendNumAndClearBuffer(tempStrBuffer);
                equationBuffer.setNextPlus(false);
              } else {
                tempStrBuffer.append(character);
              }
            });
    if (tempStrBuffer.indexOf("x") > -1) {
      equationBuffer.appendNumAndClearBuffer(tempStrBuffer);
    }
    return equationBuffer.getResult();
  }

  static class EquationBuffer {
    private BigInteger result = BigInteger.ZERO;
    private BigInteger factorNum;
    private boolean isNextPlus = true;

    public BigInteger getResult() {
      return new BigInteger(result + "");
    }

    public EquationBuffer(long factorNum) {
      this.factorNum = new BigInteger(factorNum + "");
    }

    public void add(String factorNum) {
      result = result.add(getResultNum(factorNum));
    }

    public void setNextPlus(boolean isPlus) {
      this.isNextPlus = isPlus;
    }

    private BigInteger getResultNum(String num) {
      BigInteger retVal;
      if (num.equals("x")) {
        retVal = BigInteger.ONE;
      } else {
        int xIndex = num.indexOf("x");
        if (xIndex == 0) {
          retVal = BigInteger.ONE;
        } else {
          retVal = new BigInteger(num.substring(0, xIndex));
        }
        if (num.contains("^")) {
          int indexOfPower = num.indexOf("^");
          String powerTimes = num.substring(indexOfPower + 1);
          retVal =
              retVal
                  .multiply(new BigInteger(powerTimes))
                  .multiply(
                      factorNum.pow(
                          new BigInteger(powerTimes).add(BigInteger.ONE.negate()).intValue()));
        }
      }
      if (isNextPlus) {
        return retVal;
      } else {
        return retVal.negate();
      }
    }

    public void appendNumAndClearBuffer(StringBuffer tempStrBuffer) {
      if (tempStrBuffer.length() > 0) {
        add(tempStrBuffer.toString());
        tempStrBuffer.delete(0, tempStrBuffer.length());
      }
    }
  }
}
