package com.sparta.algorithm.result.programmers;

import java.util.*;

public class _01_09_신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, HashSet<String>> reported = new HashMap<>();
        Map<String, Integer> countMail = new HashMap<>();
        for(String id : id_list){
            countMail.put(id, 0);
            reported.put(id,new HashSet<>());
        }
        for(String rep : report){
            String[] split = rep.split(" ");
            reported.get(split[1]).add(split[0]);
        }

        for (String key : reported.keySet()) {
            HashSet<String> reportedMember = reported.get(key);
            if (reportedMember.size() >= k) {
                for (String member : reportedMember) {
                    countMail.put(member, countMail.getOrDefault(member, 0) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = countMail.get(id_list[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        _01_09_신고결과받기 solution = new _01_09_신고결과받기();
        solution.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
//        solution.solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
    }
}
