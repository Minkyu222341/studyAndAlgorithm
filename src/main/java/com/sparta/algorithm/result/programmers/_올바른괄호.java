package com.sparta.algorithm.result.programmers;

class _올바른괄호 {
  boolean solution(String strings) {
    int count = 0;

    for (int i = 0; i < strings.length(); i++) {
      char c = strings.charAt(i);
      if (c == '(') {
        count += 1;
      } else {
        count -= 1;
      }
      if (count < 0) {
        return false;
      }
    }
    if (count == 0) {
      return true;
    }
    return false;
  }


  public static void main(String[] args) {
    final _올바른괄호 solution = new _올바른괄호();
    solution.solution("(((())");
  }
}
