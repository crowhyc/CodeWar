package com.javacloud.codewar;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.List;
import org.junit.Test;
/*
Alright, detective, one of our colleagues successfully observed our target person, Robby the robber. We followed him to a secret warehouse, where we assume to find all the stolen stuff. The door to this warehouse is secured by an electronic combination lock. Unfortunately our spy isn't sure about the PIN he saw, when Robby entered it.

The keypad has the following layout:

┌───┬───┬───┐
│ 1 │ 2 │ 3 │
├───┼───┼───┤
│ 4 │ 5 │ 6 │
├───┼───┼───┤
│ 7 │ 8 │ 9 │
└───┼───┼───┘
    │ 0 │
    └───┘
He noted the PIN 1357, but he also said, it is possible that each of the digits he saw could actually be another adjacent digit (horizontally or vertically, but not diagonally). E.g. instead of the 1 it could also be the 2 or 4. And instead of the 5 it could also be the 2, 4, 6 or 8.

He also mentioned, he knows this kind of locks. You can enter an unlimited amount of wrong PINs, they never finally lock the system or sound the alarm. That's why we can try out all possible (*) variations.

* possible in sense of: the observed PIN itself and all variations considering the adjacent digits

Can you help us to find all those variations? It would be nice to have a function, that returns an array (or a list in Java and C#) of all variations for an observed PIN with a length of 1 to 8 digits. We could name the function getPINs (get_pins in python, GetPINs in C#). But please note that all PINs, the observed one and also the results, must be strings, because of potentially leading '0's. We already prepared some test cases for you.

Detective, we count on you!
 */
public class ObserverPINGeneratorTest {

  private ObserverPINGenerator generator = new ObserverPINGenerator();

  @Test
  public void shouldGetOneLengthListHave4BitPIN_whenCallGetPIN() {
    List<String> results = generator.genPIN("13");
    assertThat(results, hasSize(9));
    assertThat(results, hasItem("12"));
    assertThat(results, hasItem("46"));
  }

  @Test
  public void shouldGet2AdjacentDigits_whenCallGetAdjacentDigitsWithInputString0() {
    List<String> adjacentDigits = generator.getAdjacentDigits("0");
    assertThat(adjacentDigits, hasSize(2));
    assertThat(adjacentDigits, hasItems("0", "8"));
  }

  @Test
  public void shouldGet3AdjacentDigits_whenCallGetAdjacentDigitsWithInputString1() {
    List<String> adjacentDigits = generator.getAdjacentDigits("1");
    assertThat(adjacentDigits, hasSize(3));
    assertThat(adjacentDigits, hasItems("1", "2", "4"));
  }

  @Test
  public void shouldGet4AdjacentDigits_whenCallGetAdjacentDigitsWithInputString2() {
    List<String> adjacentDigits = generator.getAdjacentDigits("2");
    assertThat(adjacentDigits, hasSize(4));
    assertThat(adjacentDigits, hasItems("1", "2", "3", "5"));
  }

  @Test
  public void shouldGet4AdjacentDigits_whenCallGetAdjacentDigitsWithInputString3() {
    List<String> adjacentDigits = generator.getAdjacentDigits("3");
    assertThat(adjacentDigits, hasSize(3));
    assertThat(adjacentDigits, hasItems("2", "3", "6"));
  }

  @Test
  public void shouldGet4AdjacentDigits_whenCallGetAdjacentDigitsWithInputString4() {
    List<String> adjacentDigits = generator.getAdjacentDigits("4");
    assertThat(adjacentDigits, hasSize(4));
    assertThat(adjacentDigits, hasItems("1", "4", "5", "7"));
  }

  @Test
  public void shouldGet5AdjacentDigits_whenCallGetAdjacentDigitsWithInputString5() {
    List<String> adjacentDigits = generator.getAdjacentDigits("5");
    assertThat(adjacentDigits, hasSize(5));
    assertThat(adjacentDigits, hasItems("2", "4", "5", "6", "8"));
  }

  @Test
  public void shouldGet4AdjacentDigits_whenCallGetAdjacentDigitsWithInputString6() {
    List<String> adjacentDigits = generator.getAdjacentDigits("6");
    assertThat(adjacentDigits, hasSize(4));
    assertThat(adjacentDigits, hasItems("3", "5", "6", "9"));
  }

  @Test
  public void shouldGet3AdjacentDigits_whenCallGetAdjacentDigitsWithInputString7() {
    List<String> adjacentDigits = generator.getAdjacentDigits("7");
    assertThat(adjacentDigits, hasSize(3));
    assertThat(adjacentDigits, hasItems("4", "7", "8"));
  }

  @Test
  public void shouldGet5AdjacentDigits_whenCallGetAdjacentDigitsWithInputString8() {
    List<String> adjacentDigits = generator.getAdjacentDigits("8");
    assertThat(adjacentDigits, hasSize(5));
    assertThat(adjacentDigits, hasItems("5", "7", "8", "9", "0"));
  }

  @Test
  public void shouldGet3AdjacentDigits_whenCallGetAdjacentDigitsWithInputString9() {
    List<String> adjacentDigits = generator.getAdjacentDigits("9");
    assertThat(adjacentDigits, hasSize(3));
    assertThat(adjacentDigits, hasItems("6", "8", "9"));
  }

  @Test
  public void shouldReturnAllCombinations_whenInputStringArray() {
    List<String> stringArrays =
        generator.assembleStringArrays(
            newArrayList(newArrayList("1", "2"), newArrayList("3", "4")));
    assertThat(stringArrays, hasSize(4));
    assertThat(stringArrays, hasItems("13", "14", "23", "24"));
  }
}
