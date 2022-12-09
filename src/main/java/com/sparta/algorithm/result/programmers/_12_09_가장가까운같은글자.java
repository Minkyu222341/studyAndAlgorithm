package com.sparta.algorithm.result.programmers;

public class _12_09_가장가까운같은글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        String[] split = s.split("");

        int now = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (!sb.toString().contains(split[i])) {
                sb.append(split[i]);
                answer[i] = -1;
            } else {
                answer[i] = i - sb.indexOf(split[i]);
                sb = new StringBuilder(sb.toString().replace(split[i], "0"));
                sb.append(split[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _12_09_가장가까운같은글자 solution = new _12_09_가장가까운같은글자();
        solution.solution("banana");
    }
}
