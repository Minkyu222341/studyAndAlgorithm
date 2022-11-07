package com.sparta.algorithm.result.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class _두개뽑아서더하기 {
  public int[] solution(int[] num) {
    int[] answer;
    int count = 0;
    HashMap<Integer, Integer> map = new HashMap();


    for (int i = 0; i < num.length - 1; i++) {
      for (int j = i + 1; j < num.length; j++) {
        int sum = (num[i] + num[j]);

        map.put(sum, map.getOrDefault(sum, 0));
      }
    }
    answer = new int[map.size()];

    for (int i : map.keySet()) {
      answer[count] = i;
      count++;
    }

    Arrays.sort(answer);

    return answer;
  }

  public static void main(String[] args) {
    final _두개뽑아서더하기 solution = new _두개뽑아서더하기();
    solution.solution(new int[]{2, 1, 3, 4, 1});
  }
}
