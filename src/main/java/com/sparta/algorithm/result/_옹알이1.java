package com.sparta.algorithm.result;

public class _옹알이1 {
  public int solution(String[] babbling) {
    int answer = 0;
    String aya = "aya";
    String ye = "ye";
    String woo = "woo";
    String ma = "ma";

    for (String s : babbling) {
      if (s.contains(aya)) {
        s = s.replace(aya, ".");
      }
      if (s.contains(ye)) {
        s = s.replace(ye, ".");
      }
      if (s.contains(woo)) {
        s = s.replace(woo, ".");
      }
      if (s.contains(ma)) {
        s = s.replace(ma, ".");
      }
      if (s.equals(".") || s.equals("..") || s.equals("...") || s.equals("....")) {
        answer++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    final _옹알이1 solution = new _옹알이1();
    solution.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"});
  }
}
