package com.sparta.algorithm.result.programmers;

import java.util.*;

public class _귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Integer integer : map.values()) {
            list.add(integer);
        }

        Collections.sort(list, Collections.reverseOrder());

        Integer first = list.get(0);
        if (first >= k) {
            return 1;
        }
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            answer++;
            if (sum >= k) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _귤고르기 solution = new _귤고르기();
        solution.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
    }
}
