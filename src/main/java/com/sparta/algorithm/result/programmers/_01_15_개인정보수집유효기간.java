package com.sparta.algorithm.result.programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class _01_15_개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        typeExtraction(terms, map);

        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            String[] period = split[0].split("[.]");
            String type = split[1];
            int year = Integer.parseInt(period[0]);
            int month = Integer.parseInt(period[1]);
            String day = period[2];

            month += map.get(type);

            if (month > 12) {
                year++;
                month -= 12;
            }

            String deadLine = year + "." + month + "." + day;
            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
            Date todayOfDate = format.parse(today);
            Date deadLineOfDate = format.parse(deadLine);
            if (todayOfDate.after(deadLineOfDate) || todayOfDate.equals(deadLineOfDate)) {
                list.add(i + 1);
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        for (int i : answer) {
            System.out.println(i);
        }
        return answer;
    }

    private void typeExtraction(String[] terms, HashMap<String, Integer> map) {
        for (String term : terms) {
            String[] split = term.split(" ");
            map.put(split[0], Integer.parseInt(split[1]));
        }
    }

    public static void main(String[] args) throws ParseException {
        _01_15_개인정보수집유효기간 solution = new _01_15_개인정보수집유효기간();
//        solution.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
//        solution.solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"});
        solution.solution("2019.12.28", new String[]{"A 1"}, new String[]{"2018.12.1 A"});
    }
}
