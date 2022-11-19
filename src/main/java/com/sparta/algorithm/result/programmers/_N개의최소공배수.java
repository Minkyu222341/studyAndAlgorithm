package com.sparta.algorithm.result.programmers;

import java.util.Arrays;

public class _N개의최소공배수 {
  public int solution(int[] arr) {
    Arrays.sort(arr);
    int answer = arr[arr.length - 1];
    int count = 0;


    while (true) {
      for (int i : arr) {
        if (answer % i == 0) {
          count++;
        }
      }
      if (count == arr.length) {
        break;
      }
      answer += arr[arr.length-1];

      count = 0;
    }
    return answer;
  }

  public static void main(String[] args) {
    final _N개의최소공배수 solution = new _N개의최소공배수();
    solution.solution(new int[]{3,4,9,16});
  }
}
