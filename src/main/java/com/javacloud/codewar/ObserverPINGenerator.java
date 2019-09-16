package com.javacloud.codewar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ObserverPINGenerator {

  private static String[][] PINPanel = {
    {"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}, {"", "0", ""}
  };

  public static List<String> genPIN(String observed) {
    List<List<String>> adjacentResults =
        Arrays.stream(observed.split(""))
            .map(ObserverPINGenerator::getAdjacentDigits)
            .collect(Collectors.toList());

    return assembleStringArrays(adjacentResults);
  }

  static List<String> getAdjacentDigits(String s) {
    int PINRow = (Integer.valueOf(s) - 1) / 3; // -1 cause by 3/3 is 1 not expect 0
    int PINColumn = Integer.valueOf(s) - (PINRow * 3) - 1;
    List<String> result = new ArrayList<>();
    if (s.equals("0")) {
      result.add("0");
      result.add("8");
      return result;
    }
    result.add(getValidVal(PINRow - 1, PINColumn));
    result.add(getValidVal(PINRow, PINColumn - 1));
    result.add(getValidVal(PINRow, PINColumn));
    result.add(getValidVal(PINRow, PINColumn + 1));
    result.add(getValidVal(PINRow + 1, PINColumn));
    return result.stream().filter(str -> str.length() > 0).collect(Collectors.toList());
  }

  private static String getValidVal(int row, int column) {
    String val;
    try {
      val = PINPanel[row][column];
    } catch (IndexOutOfBoundsException i) {
      return "";
    }
    return val;
  }

  static List<String> assembleStringArrays(List<List<String>> arrays) {
    List<String> results = new ArrayList<>();
    calculateCombination(arrays, 0, new String[arrays.size()], results);
    return results;
  }

  public static void calculateCombination(
      List<List<String>> inputList, int beginIndex, String[] PIN, List<String> results) {
    if (beginIndex == inputList.size()) {
      results.add(String.join("", PIN));
      return;
    }
    for (String c : inputList.get(beginIndex)) {
      PIN[beginIndex] = c;
      calculateCombination(inputList, beginIndex + 1, PIN, results);
    }
  }
}
