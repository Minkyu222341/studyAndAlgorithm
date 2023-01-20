package com.sparta.algorithm.result.programmers.lv1;

public class _12_22_크기가작은부분문자열 {
    public int solution(String t, String p) {
        int answer = 0;
        try {
            for (int i = 0; i < t.length(); i++) {
                String num = t.substring(i, i + p.length());
                if (num.compareTo(p) < 1) {
                    answer++;
                }
            }
        } catch (Exception e) {
            System.out.println("end");
        }
        return answer;
    }

    public static void main(String[] args) {
        _12_22_크기가작은부분문자열 solution = new _12_22_크기가작은부분문자열();
        solution.solution("500220839878", "7");
    }
}
