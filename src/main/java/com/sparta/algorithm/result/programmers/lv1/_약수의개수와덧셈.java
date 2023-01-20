package com.sparta.algorithm.result.programmers.lv1;

import java.util.ArrayList;

public class _약수의개수와덧셈 {
  public int solution(int left, int right) {
    int answer = 0;
    int count ;
    final ArrayList<Integer> arrayList = new ArrayList<>();

    for (int i = left; i <= right; i++) {
      arrayList.add(i);
    }

    for (Integer integer : arrayList) {
      count = 0;
      for (int i = 1; i <= integer; i++) {
        if (integer % i == 0) {
          count++;
        }
      }
      if (count % 2 == 0) {
        answer += integer;
      } else {
        answer -= integer;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    final _약수의개수와덧셈 solution = new _약수의개수와덧셈();
    solution.solution(13, 17);
  }
}
