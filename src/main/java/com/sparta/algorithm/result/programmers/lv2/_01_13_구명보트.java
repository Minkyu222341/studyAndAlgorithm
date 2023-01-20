package com.sparta.algorithm.result.programmers.lv2;

import java.util.Arrays;

public class _01_13_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        if (people[0] > limit) {
            return people.length;
        }

        int min = 0;

        for (int i = people.length - 1; min <= i; i--){
            if (people[min] + people[i] <= limit) {
                min++;
            }
            answer++;
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        _01_13_구명보트 solution2 = new _01_13_구명보트();
        solution2.solution(new int[]{70, 60, 80, 60}, 100);
    }
}
