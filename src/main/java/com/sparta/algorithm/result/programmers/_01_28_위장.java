package com.sparta.algorithm.result.programmers;

import java.util.HashMap;

public class _01_28_위장 {
    public int solution(String[][] clothes) {
        int num = 1;
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        insertData(clothes, map);

        if (map.size() == 1) {
            return clothes.length;
        }

        num = counting(num, map);


        return num-1;
    }

    private void insertData(String[][] clothes, HashMap<String, Integer> map) {
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
    }

    private int counting(int num, HashMap<String, Integer> map) {
        for (Integer value : map.values()) {
            if (num == 0) {
                num = value;
            }
            num *= (value+1);
        }
        return num;
    }


    public static void main(String[] args) {
        _01_28_위장 solution = new _01_28_위장();
//        solution.solution(new String[][]{{"yellow_hat", "headgear"},{ "blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
        solution.solution(new String[][]{{"crow_mask", "face"},{ "blue_sunglasses", "face"}, {"smoky_makeup", "face"}});
    }
}
