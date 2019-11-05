package com.javacloud.codewar

import spock.lang.Specification

/**
 * A *Hamming number* is a positive integer of the form 2i3j5k, for some non-negative integers i, j, and k.
 *
 * Write a function that computes the nth smallest Hamming number.
 *
 * Specifically:
 *
 * The first smallest Hamming number is 1 = 203050
 * The second smallest Hamming number is 2 = 213050
 * The third smallest Hamming number is 3 = 203150
 * The fourth smallest Hamming number is 4 = 223050
 * The fifth smallest Hamming number is 5 = 203051
 * The 20 smallest Hamming numbers are given in example test fixture.
 *
 * Your code should be able to compute all of the smallest 5,000 (Clojure: 2000) Hamming numbers without timing out.
 */
class HammingTest extends Specification {

    def hamming = new Hamming()

    def "test 20 smallest hamming numbers"() {
        given:

        expect:
        hamming.hamming(num) == result

        where:
        num | result
        1   | 1L
        2   | 2L
        3   | 3L
        4   | 4L
        5   | 5L
        6   | 6L
        7   | 8L
        8   | 9L
        9   | 10L
        10  | 12L
        11  | 15L
        12  | 16L
        13  | 18L
        14  | 20L
        15  | 24L
        16  | 25L
        17  | 27L
        18  | 30L
        19  | 32L
    }

    def "test 2000 smallest hamming numbers"() {
        expect:
        hamming.hamming(2000)

    }
}
