package com.sparta.algorithm.test;

import java.util.*;

public class ex2 {
    public int[] solution(int[] grade) {
        int[] answer = new int[grade.length];
        Map<Integer, Integer> scoreMap = new HashMap<>();
        Map<Integer, Integer> rankMap = new HashMap<>();
        for(int i=0; i<grade.length; i++){
            scoreMap.put(grade[i],scoreMap.getOrDefault(grade[i],0)+1);
        }

        List<Integer> scoreKey = new ArrayList<>(scoreMap.keySet());
        scoreKey.sort((o1,o2) -> o2-o1);
        for (Integer integer : scoreKey) {
            System.out.println(integer);
        }
        int rank = 1;
        for(int i=0; i<scoreKey.size(); i++){
            rankMap.put(scoreKey.get(i),rank);
            rank += scoreMap.get(scoreKey.get(i));
        }
        for(int i=0; i<grade.length; i++){
            answer[i] = rankMap.get(grade[i]);
        }

//        for (int i : answer) {
//            System.out.println(i);
//        }

        return answer;
    }

    public static void main(String[] args) {
        ex2 solution = new ex2();
//        solution.solution(new int[]{2, 2, 1});
        solution.solution(new int[]{3, 2, 1, 2});
//        solution.solution(new int[]{1,1,1,1,1,1,1,1,2});
    }
}
