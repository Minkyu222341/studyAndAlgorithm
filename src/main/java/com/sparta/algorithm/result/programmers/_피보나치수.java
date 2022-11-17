package com.sparta.algorithm.result.programmers;

public class _피보나치수 {
    public int solution(int n) {
        int answer = 0;
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            answer = first + second % 1234567;
            if (i % 2 == 0) {
                first =answer;
            } else {
                second =answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        _피보나치수 solution = new _피보나치수();
        solution.solution(3);
    }
}
