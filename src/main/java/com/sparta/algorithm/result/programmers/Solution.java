package com.sparta.algorithm.result.programmers;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int num = 0;
        HashSet<Integer> set = new HashSet<>();

        int[] newEle = Arrays.copyOf(elements, elements.length*2);

        for (int i = elements.length; i < newEle.length; i++) {
            newEle[i] = newEle[num++];
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{7, 9, 1, 1, 4});
    }
}
