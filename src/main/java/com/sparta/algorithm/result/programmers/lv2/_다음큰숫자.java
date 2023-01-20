package com.sparta.algorithm.result.programmers.lv2;

public class _다음큰숫자 {

  public int solution(int n) {
    int answer = 0;
    int requestNumberDecimalToBinaryCount = Integer.bitCount(n);
    int flagNumber = n + 1;

    for (int i = flagNumber; i <= 1000000; i++) {
      int decimalToBinaryCount = Integer.bitCount(i);
      if (requestNumberDecimalToBinaryCount == decimalToBinaryCount) {
        answer = i;
        break;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    final _다음큰숫자 solution = new _다음큰숫자();
    solution.solution(78);
  }
}
