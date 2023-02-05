package com.sparta.algorithm.test;

import java.util.*;

public class Solution {
    public int[] solution(int[] grade) {
        int[] answer = new int[grade.length];
        Map<Integer, Integer> scoreMap = new HashMap<>();
        Map<Integer, Integer> rankMap = new HashMap<>();
        for(int i=0; i<grade.length; i++){
            scoreMap.put(grade[i],scoreMap.getOrDefault(grade[i],0)+1);
        }

        List<Integer> scoreKey = new ArrayList<>(scoreMap.keySet());
        scoreKey.sort((o1,o2) -> o2-o1);
        int rank = 1;
        for(int i=0; i<scoreKey.size(); i++){
            rankMap.put(scoreKey.get(i),rank);
            rank += scoreMap.get(scoreKey.get(i));
        }
        for(int i=0; i<grade.length; i++){
            answer[i] = rankMap.get(grade[i]);
        }

        for (int i : answer) {
            System.out.println(i);
        }



//        Integer[] arr = Arrays.stream(grade).boxed().toArray(Integer[]::new);
//        Arrays.sort(arr, Collections.reverseOrder());
//        int rank = 1;
//        Map<Integer,Integer> map = new HashMap<>();
//        int number = 1;
//        for(int i=0; i< arr.length-1; i++){
//            if(arr[i] == arr[i+1]){
//                map.put(arr[i],rank);
//                number++;
//            }else{
//                map.put(arr[i],rank);
//                rank += number;
//                number = 1;
//            }
//        }
//        map.put(arr[arr.length-1],rank);
//        for(int i=0; i<grade.length; i++){
//            answer[i] = map.get(grade[i]);
//        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution(new int[]{2, 2, 1});
        solution.solution(new int[]{3, 2, 1, 2});
//        solution.solution(new int[]{1,1,1,1,1,1,1,1,2});
    }
}
