package com.sparta.algorithm.result;

public class _JadenCase문자열만들기 {
  public String solution(String request) {
    String[] s = request.split("");
    String result = "";
    String first = s[0].toUpperCase();
    result += first;
    for (int i = 0; i < s.length - 1; i++) {
      if (s[i].equals(" ")) {
        result += s[i+1].toUpperCase();
      } else {
        result += s[i+1].toLowerCase();
      }
    }
    return result;
  }

  public static void main(String[] args) {
    _JadenCase문자열만들기 solution = new _JadenCase문자열만들기();
    solution.solution("3people unFollowed me");
    solution.solution("for the last week");
  }
}
