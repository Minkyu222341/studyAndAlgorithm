package com.sparta.algorithm.result.programmers.lv2;

import java.util.Arrays;

public class _전화번호목록 {
  public boolean solution(String[] phoneBook) {
    boolean answer = true;
    Arrays.sort(phoneBook);

    for (int i = 0; i < phoneBook.length - 1; i++)
      if (phoneBook[i + 1].startsWith(phoneBook[i])){
        System.out.println("false");
        return false;
      }

    return answer;
  }

  public static void main(String[] args) {
    final _전화번호목록 solution = new _전화번호목록();
    solution.solution(new String[]{"11922","112412419", "97674223", "35125"});
  }
}
