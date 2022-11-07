package com.sparta.algorithm.result.programmers;

import java.util.*;

class _문자열내림차순으로배치하기 {
  public String solution(String s) {
    String answer = "";
    ArrayList list = new ArrayList();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      list.add(c);
    }
    Collections.sort(list, Collections.reverseOrder());

    for (int i = 0; i < list.size(); i++) {
      answer += list.get(i);
    }

    return answer;
  }
}