package com.sparta.algorithm.test;

import java.util.Arrays;

public class ex4 {
    public int solution(int[] p) {
        int answer = 0;

        Arrays.sort(p);

        int min = 0;

        for (int i = p.length - 1; min <= i; i--){
            if (p[min] < p[i] && min < p.length - 1) {
                min++;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        ex4 solution3 = new ex4();
        solution3.solution(new int[]{3, 2, 1, 4, 5});
        solution3.solution(new int[]{20, 10, 10, 20});
//        solution3.solution(new int[]{103, 101, 103, 103, 101, 102, 100, 100, 101, 104});
    }
}
