package com.javacloud.codewar;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import org.junit.Test;

/**
 * Create a function that differentiates a polynomial for a given value of x.
 *
 * <p>Your function will receive 2 arguments: a polynomial as a string, and a point to evaluate the
 * equation as an integer.
 *
 * <p>Assumptions: There will be a coefficient near each x, unless the coefficient equals 1 or -1.
 * There will be an exponent near each x, unless the exponent equals 0 or 1. All exponents will be
 * greater or equal to zero Examples: Equation.differenatiate("12x+2", 3) ==> 12
 * Equation.differenatiate("x^2+3x+2", 3) ==> 9
 */
public class EquationTest {
  private Equation equation = new Equation();

  @Test
  public void shouldEquationDifferentiateReturn12_whenInputPolynomial12xPlus2And3() {
    BigInteger result = equation.differentiate("12x+2", 3);
    assertEquals(result, new BigInteger("12"));
  }

  @Test
  public void shouldEquationDifferentiateReturn5_whenInputPolynomialxPower2And3() {

    BigInteger result = equation.differentiate("x^2-x", 3);
    assertEquals(result, new BigInteger("5"));
  }

  @Test
  public void
      shouldEquationDifferentiateReturnMinus20_whenInputPolynomialMinus5xPower2Plus10xPlus4And3() {

    BigInteger result = equation.differentiate("-5x^2+10x+4", 3);
    assertEquals(result, new BigInteger("-20"));
  }

  @Test
  public void
  shouldEquationDifferentiateReturnMinus105_whenInputPolynomialMinus5xPower3Plus10xPlus4And3() {

    BigInteger result = equation.differentiate("-5x^3+10x+4", 3);
    assertEquals(result, new BigInteger("-125"));
  }
}
