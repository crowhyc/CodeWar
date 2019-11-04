package com.javacloud.codewar;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/*
Rail Fence Cipher: Encoding and Decoding
Create two functions to encode and then decode a string using the Rail Fence Cipher. This cipher is used to encode a string by placing each character successively in a diagonal along a set of "rails". First start off moving diagonally and down. When you reach the bottom, reverse direction and move diagonally and up until you reach the top rail. Continue until you reach the end of the string. Each "rail" is then read left to right to derive the encoded string. You can optionally include or dis-include punctuation.

For example, the string "WEAREDISCOVEREDFLEEATONCE" could be represented in a three rail system as follows:

W       E       C       R       L       T       E
  E   R   D   S   O   E   E   F   E   A   O   C
    A       I       V       D       E       N
The encoded string would be:

WECRLTEERDSOEEFEAOCAIVDEN
Write a function/method that takes 2 arguments, a string and the number of rails, and returns the ENCODED string.

Write a second function/method that takes 2 arguments, an encoded string and the number of rails, and returns the DECODED string.

For both encoding and decoding, assume number of rails >= 2 and that passing an empty string will return an empty string.

Note that the example above excludes the punctuation and spaces just for simplicity. There are, however, tests that include punctuation. Don't filter out the punctuation as they are a part of the string.
 */
public class RailFenceCipherTest {

  private final String srcStr = "WEAREDISCOVEREDFLEEATONCE";

  @Test
  public void shouldReturnEmptyString_whenEncodeEmptyStr() {
    String encode = RailFenceCipher.encode("", 3);
    assertThat(encode, nullValue());
  }

  @Test
  public void shouldReturnEmptyString_whenEncodeRail2() {
    String encode = RailFenceCipher.encode(srcStr, 2);
    assertThat(encode, nullValue());
  }

  @Test
  public void shouldReturnCorrectEncodedString_whenDeep25() {
    String encode = RailFenceCipher.encode(srcStr, 25);
    assertThat(encode, is(srcStr));
  }
  @Test
  public void shouldReturnCorrectEncodedString_whenDeep5() {
    String encode = RailFenceCipher.encode(srcStr, 7);
    System.out.println(encode);
  }
  @Test
  public void shouldReturnStringBeforeEncode() {
    String encode = RailFenceCipher.encode(srcStr, 3);

    String decode = RailFenceCipher.decode(encode, 3);

    assertThat(decode, is(srcStr));
  }
}
