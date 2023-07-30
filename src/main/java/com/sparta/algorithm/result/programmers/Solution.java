package com.sparta.algorithm.result.programmers;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();

        int quantity = 0;

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);

            quantity += number[i];
        }


        return 0;
    }



    private static Integer valid(Map<String, Integer> map, int index) {
        int num = 0;
        for (Integer value : map.values()) {
            num += value;
        }

        if (num == 0) {
            return index;
        }
        return 0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana",
                        "pork", "rice", "pot", "banana", "apple", "banana"});
    }
}
