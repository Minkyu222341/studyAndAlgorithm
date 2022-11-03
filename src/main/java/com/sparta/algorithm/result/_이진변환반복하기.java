package com.sparta.algorithm.result;

public class _이진변환반복하기 {
  public int[] solution(String s) {
    int[] answer = new int[2];
    int count = 0;
    int zeroCount = 0;
    while (true) {
      int beforeLength = s.length();
      String replace = s.replace("0", "");
      zeroCount += beforeLength - replace.length();
        s = Integer.toBinaryString(replace.length());
        count++;
        if (s.equals("1")) {
          break;
        }
    }
    answer[0] = count;
    answer[1] = zeroCount;

    return answer;
  }

  public static void main(String[] args) {
    final _이진변환반복하기 solution = new _이진변환반복하기();
    solution.solution("110010101001");
  }
}