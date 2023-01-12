package com.sparta.algorithm.result.programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        int[] answer = {};
        ArrayList<Integer> count = new ArrayList<Integer>();


        for (int i = 0; i < privacies.length; i++) {
            String[] collectionDate = privacies[i].split(" ");
            String[] splitDate = collectionDate[0].split("[.]");
            int year = Integer.parseInt(splitDate[0]);
            int month = Integer.parseInt(splitDate[1]);
            int day = Integer.parseInt(splitDate[2]);
            String type = collectionDate[1];

            for (String term : terms) {
                if (term.contains(type)) {
                    type = term.split(" ")[1];
                }
            }

            day = day + (28 * Integer.parseInt(type))-1;
            System.out.println(day);

            while (day > 28) {
                month++;
                day -= 28;
            }

            while (month > 12) {
                year++;
                month -= 12;
            }


            String deadLine = year + "." + month + "." + day;
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
            Date todayOfDate = format.parse(today);
            Date deadLineOfDate = format.parse(deadLine);
            System.out.println("------------------");
            if (todayOfDate.after(deadLineOfDate)) {
                System.out.println("*파기 정보*");
                count.add(i + 1);
            }
            System.out.println("마감 : " + deadLine);
            System.out.println("오늘 : " + today);
        }
        answer = new int[count.size()];

        for (int i = 0; i < count.size(); i++) {
            answer[i] = count.get(i);
        }
        for (int i : answer) {
            System.out.println(i);
        }
        return answer;
    }

    public static void main(String[] args) throws ParseException {
        Solution solution = new Solution();
        solution.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
//        solution.solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"});
//        solution.solution("2019.12.28", new String[]{"A 1"}, new String[]{"2019.12.1 A"});
    }
}
