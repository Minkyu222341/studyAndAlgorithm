package com.sparta.algorithm.result;

public class _최대공약수와최소공배수 {
  public int[] solution(int n, int m) {
    int[] answer;
    int theGreatestCommonDenominator = 0;

    for (int i = 1; i <= n && i <= m; i++) {
      if (n % i == 0 && m % i == 0) {
        theGreatestCommonDenominator = i;
      }
    }
    int minimumCommonMultiple = (n * m) / theGreatestCommonDenominator;
    answer = new int[]{theGreatestCommonDenominator, minimumCommonMultiple};

    return answer;
  }

  public static void main(String[] args) {
    final _최대공약수와최소공배수 solution = new _최대공약수와최소공배수();
    solution.solution(3,12);
  }
}
