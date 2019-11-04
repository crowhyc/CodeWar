package com.javacloud.codewar


import spock.lang.Specification
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
class EquationTest extends Specification {

    def "shouldEquationDifferentiateReturn12_whenInputPolynomial12xPlus2And3"() {
        given:
        def equation = new Equation()
        expect:
        equation.differentiate(equationVal, xVal) == result
        where:
        equationVal << ["12x+2", "x^2-x", "-5x^2+10x+4", "-5x^3+10x+4"]
        xVal = 3
        result << [new BigInteger("12"), new BigInteger("5"), new BigInteger("-20"), new BigInteger("-125")]
    }

}
