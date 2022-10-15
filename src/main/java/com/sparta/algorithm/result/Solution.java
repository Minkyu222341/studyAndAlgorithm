package com.sparta.algorithm.result;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

class Solution {
  public int solution(int[] elements) {
    int answer = 0;
    int count = 0 ;
    HashSet<Object> num = new HashSet<>();

    for (int i = 0; i < elements.length; i++) {
      while (true) {
        num.add(elements[i]);
        count++;
      }
    }

    num.stream().sorted().forEach(System.out::println);
    return answer;
  }

}