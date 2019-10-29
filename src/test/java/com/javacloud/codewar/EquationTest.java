package com.javacloud.codewar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Create a function that differentiates a polynomial for a given value of x.
 *
 * <p>Your function will receive 2 arguments: a polynomial as a string, and a point to evaluate the
 * equation as an integer.
 *
 * <p>Assumptions: There will be a coefficient near each x, unless the coefficient equals 1 or -1.
 * There will be an exponent near each x, unless the exponent equals 0 or 1. All exponents will be
 * greater or equal to zero
 * Examples:
 *          Equation.differenatiate("12x+2", 3) ==> 12
 *          Equation.differenatiate("x^2+3x+2", 3) ==> 9
 */
public class EquationTest {
  private Equation equation = new Equation();

  @Test
  public void shouldEquationDifferentiateReturn5_whenInputPolynomialXAndEquals5() {
    int result = equation.differentiate("x", 5);
    assertThat(result, is(5));
  }

  @Test
  public void shouldReturn5_whenInput5XAnd25() {
    int result = equation.differentiate("5x", 25);
    assertThat(result, is(5));
  }
}
