package com.sparta.algorithm.result.programmers;

import java.util.Arrays;
import java.util.HashSet;

public class _02_14_연속부분수열합의갯수 {
    public int solution(int[] elements) {
        int answer = 0;
        int num = 0;
        int count = 1;
        HashSet<Integer> set = new HashSet<>();

        int[] newEle = Arrays.copyOf(elements, elements.length*2);

        //배열의 길이가 초과되기 때문에 똑같은 값을 2배로 복사
        for (int i = elements.length; i < newEle.length; i++) {
            newEle[i] = newEle[num++];
        }

        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                set.add(Arrays.stream(newEle, j, j + count).sum());
                //배열의 n번째부터 n번째까지 더한값
            }
            count++;
        }

        System.out.println(set);

        return set.size();
    }

    public static void main(String[] args) {
        _02_14_연속부분수열합의갯수 solution = new _02_14_연속부분수열합의갯수();
        solution.solution(new int[]{7, 9, 1, 1, 4});
    }
}
// 7 9 1 1 4   7 9 1 1 4
// 16 10 2 5 11