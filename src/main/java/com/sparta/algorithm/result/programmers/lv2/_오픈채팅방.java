package com.sparta.algorithm.result.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class _오픈채팅방 {
    public String[] solution(String[] record) {
        String[] answer;
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] s1 = record[i].split(" ");
            String action = s1[0];
            String id = s1[1];
            if (!action.equals("Leave")) {
                String name = s1[2];
                map.put(id, name);
            }
        }

        for (int i = 0; i < record.length; i++) {
            String[] s1 = record[i].split(" ");
            String action = s1[0];
            String id = s1[1];
            if (action.equals("Enter")) {
                list.add(map.get(id) + "님이 들어왔습니다.");
            }
            if (action.equals("Leave")) {
                list.add(map.get(id) + "님이 나갔습니다.");
            }
        }
        list.removeAll(Collections.singletonList(null));

        answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        _오픈채팅방 solution = new _오픈채팅방();
        solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
    }
}
