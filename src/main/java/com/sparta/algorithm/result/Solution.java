package com.sparta.algorithm.result;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

class Solution {
  public int solution(int[] elements) {
    int answer = 0;
    int count = 1;
    HashSet<Object> num = new HashSet<>();
    for (int i = 0; i < elements.length; i++) {
      num.add(elements[i]);
      count++;
      for (int j = 0; j < count; j++) {
        num.add(elements[i] + elements[j]);
      }
    }
    num.stream().sorted().forEach(System.out::println);
    return answer;
  }
}