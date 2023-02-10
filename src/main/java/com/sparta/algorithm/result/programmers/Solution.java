package com.sparta.algorithm.result.programmers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

// 97 ~ 122
public class Solution {

    public int solution(String str1, String str2) {
        int same = 0;
        double num = 0;
        String first = str1.toLowerCase();
        String second = str2.toLowerCase();
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map1 = new HashMap<>();

        makeGathering(first, sb, map);

        for (String key : map.keySet()) {
            if (map.get(key) >= 2) {
                map1.put(key, map.get(key));
            }
        }

        clearData(sb);
        makeGathering(second, sb, map);

        double union = map.size();

        for (String key : map.keySet()) {
            if (map.get(key) >= 2 && key.length() >= 2) {
                same++;
            }
        }


        num = ((double) same) / union;
        System.out.println(map);
        int round = (int) Math.round(num * 65536);


        if(round==0) return 65536;

        return round;
    }

    public void clearData(StringBuilder sb) {
        sb.setLength(0);
    }


    private void makeGathering(String str, StringBuilder sb, HashMap<String, Integer> map) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 97 || c > 122) {
                sb.setLength(0);
                continue;
            }
            sb.append(c);

            if (sb.length() == 2) {
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
                sb = new StringBuilder(sb.substring(1));
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution("FRANCE", "french");
//        solution.solution("handshake", "shake hands");
//        solution.solution("E=M*C^2", "e=m*c^2");
        solution.solution("aa1+aa2", "AAAA12");
    }
}