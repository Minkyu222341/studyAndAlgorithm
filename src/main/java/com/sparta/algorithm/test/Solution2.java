package com.sparta.algorithm.test;

import java.util.*;

public class Solution2 {
    public int solution(int N, int[][] relation, String[] dirname) {
        int answer = 0;
        Arrays.sort(relation, (o1, o2) -> o1[0] - o2[0]);
        Map<Integer, String> map = new HashMap<>();
        System.out.println(relation.length);
        StringBuilder sb = new StringBuilder();
        map.put(1, sb.append(dirname[0]).toString());
        sb.setLength(0);
        for (int i = 0; i < relation.length; i++) {
            sb.append(map.get(relation[i][0])).append("/").append(dirname[relation[i][1] - 1]);
            map.put(relation[i][1], sb.toString());
            sb.setLength(0);
        }
        List<Integer> mapkey = new ArrayList<>(map.keySet());
        mapkey.sort((o1, o2) -> map.get(o2).length() - map.get(o1).length());
        answer = map.get(mapkey.get(0)).length();
        return answer;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(7, new int[][]{{1, 2}, {2, 5}, {2, 6}, {1, 3}, {1, 4}, {3, 7}, {7, 8}}, new String[]{"root", "abcd", "cs", "hello", "etc", "hello", "solution", "test"});
    }
}
