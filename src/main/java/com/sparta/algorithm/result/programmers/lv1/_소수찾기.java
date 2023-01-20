package com.sparta.algorithm.result.programmers.lv1;

public class _소수찾기 {
  public int solution(int n) {
    int answer = 0;
    int[] num = new int[n + 1];

    for (int i = 2; i <= n; i++) {
      num[i] = i;
    }

    for (int i = 2; i <= n; i++) {
      if (num[i] == 0) continue;

      for (int j = 2 * i; j <= n; j += i) {
        num[j] = 0;
      }
    }

    for(int i=0; i<num.length; i++) {
      if(num[i]!=0) {
        answer++;
      }
    }

    System.out.println(n);
      return answer;
    }

    public static void main (String[]args){
      final _소수찾기 solution = new _소수찾기();
      solution.solution(10);
    }
  }
