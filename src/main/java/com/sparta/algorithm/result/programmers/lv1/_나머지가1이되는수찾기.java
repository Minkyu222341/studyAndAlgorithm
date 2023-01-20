package com.sparta.algorithm.result.programmers.lv1;

import java.util.*;

public class _나머지가1이되는수찾기 {
  public int solution(int n) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 2; i < n; i++) {
      if (n % i == 1) {
        list.add(i);
      }
    }
    Collections.sort(list);
    return list.get(0);
  }

  public static void main(String[] args) {
    final _나머지가1이되는수찾기 solution = new _나머지가1이되는수찾기();
    solution.solution(10);
  }
}
