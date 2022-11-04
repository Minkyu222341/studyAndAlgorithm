package com.sparta.algorithm.result;

import java.util.*;

public class _최솟값만들기 {
  public int solution(int[] A, int[] B) {
    int answer = 0;
    Arrays.sort(A);
    Integer[] listB = new Integer[B.length];

    for (int i = 0; i < listB.length; i++) {
      listB[i] = B[i];
    }
    Arrays.sort(listB, Collections.reverseOrder());

    for (int i = 0; i < A.length; i++) {
      answer += A[i] * listB[i];
    }
    return answer;
  }

  public static void main(String[] args) {
    final _최솟값만들기 solution = new _최솟값만들기();
    solution.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
  }
}
