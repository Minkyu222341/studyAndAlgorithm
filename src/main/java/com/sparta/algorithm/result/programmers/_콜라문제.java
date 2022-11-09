package com.sparta.algorithm.result.programmers;

public class _콜라문제 {
  public int solution(int a, int b, int n) {
    int answer = 0;
    while (true) {
      answer += n / a * b;
      n = (n / a * b) + n % a;
      if (n < a) {
        break;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    final _콜라문제 solution = new _콜라문제();
    solution.solution(2, 1, 20);
  }
}
