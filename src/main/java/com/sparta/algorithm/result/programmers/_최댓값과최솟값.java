package com.sparta.algorithm.result.programmers;

import java.util.ArrayList;
import java.util.Collections;

public class _최댓값과최솟값 {
  public String solution(String str) {
    String[] strings = str.split(" ");
    ArrayList numList = new ArrayList();
    for (String string : strings) {
      int i = Integer.parseInt(string);
      numList.add(i);
    }

    Collections.sort(numList);

    Object first = numList.get(0);
    Object last = numList.get(numList.size() - 1);

    return first + " " + last;
  }
  public static void main(String[] args) {
    _최댓값과최솟값 solution = new _최댓값과최솟값();
    solution.solution("1 2 3 4");
  }
}
