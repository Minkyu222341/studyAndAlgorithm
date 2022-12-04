package com.sparta.algorithm.result.programmers;

public class _문자열나누기 {
    private static final String EMPTY = "EMPTY";

    public int solution(String s) {
        int answer = 0;
        String[] split = s.split("");
        int x = 0;
        int next = 0;
        String valid = EMPTY;

        for (int i = 0; i < split.length; i++) {
            if (valid.equals(EMPTY)) {
                valid = split[i];
            }

            if (valid.equals(split[i])) {
                x++;
            } else {
                next++;
            }

            if (x == next) {
                x = 0;
                next = 0;
                answer++;
                valid = EMPTY;
            }
        }
        if (x != 0 || next != 0) {
            answer++;
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        _문자열나누기 solution = new _문자열나누기();
        solution.solution("abracadabra");
    }
}
