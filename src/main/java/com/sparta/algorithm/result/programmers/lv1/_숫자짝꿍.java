package com.sparta.algorithm.result.programmers.lv1;

import java.util.HashMap;

public class _숫자짝꿍 {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> xCount = new HashMap<>();
        HashMap<String, Integer> yCount = new HashMap<>();

        String[] xSplit = X.split("");
        String[] ySplit = Y.split("");

        for (String s : xSplit) {
            xCount.put(s, xCount.getOrDefault(s, 0) + 1);
        }
        for (String s : ySplit) {
            yCount.put(s, yCount.getOrDefault(s, 0) + 1);
        }

        for (int i = 9; i >=0; i--) {
            Integer getX = xCount.get(String.valueOf(i));
            Integer getY = yCount.get(String.valueOf(i));
            if (getY != null && getX != null) {
                int min = Math.min(getY, getX);
                for (int j = 0; j < min; j++) {
                    sb.append(i);
                }
            }
        }

        if (sb.equals("")) {
            return "-1";
        }
        if (sb.toString().replace("0", "").equals("")) {
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _숫자짝꿍 solution = new _숫자짝꿍();
        solution.solution("100","20024");
    }
}

