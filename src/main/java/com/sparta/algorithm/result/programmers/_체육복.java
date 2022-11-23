package com.sparta.algorithm.result.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class _체육복 {
  public int solution(int n, int[] lost, int[] reserve) {
    int answer = 0;
    Arrays.sort(lost);
    Arrays.sort(reserve);
    ArrayList<Integer> list = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i : lost) {
      list.add(i);
    }
    for (int i : reserve) {
      map.put(i, i);
    }

    for (int i = 0; i < list.size(); i++) {
      if (map.get(list.get(i)) != null) {
        map.remove(list.get(i));
        list.remove(i);
        i--;
      }
    }

    System.out.println(map);
    for (int i = 0; i < list.size(); i++) {
      int before = list.get(i) - 1;
      int next = list.get(i) + 1;
      if (map.get(before) != null) {
        map.remove(before);
        answer++;
      } else if (map.get(next) != null) {
        map.remove(next);
        answer++;
      }
    }
    System.out.println(n-(list.size()-answer));
    return n - (list.size() - answer);
  }

  public static void main(String[] args) {
    final _체육복 solution = new _체육복();
    solution.solution(5, new int[]{1, 2, 4, 5}, new int[]{2, 3, 4});
  }
}
