package com.sparta.algorithm.result.programmers;

public class _대기2 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        _대기2 solution = new _대기2();
        solution.solution(new int[]{2,3,3,5});
    }
}
