package algorithm.result.programmers.lv2;

public class _OX퀴즈 {
  public String[] solution(String[] quiz) {
    String[] answer = new String[quiz.length];
    int result = 0;

    for (int i = 0 ; i<quiz.length ; i++) {
      final String[] split = quiz[i].split(" ");
      int X = Integer.parseInt(split[0]);
      int Y = Integer.parseInt(split[2]);
      int Z = Integer.parseInt(split[4]);
      String sign = split[1];
      if (sign.equals("+")) {
        result = X + Y;
      } else {
        result = X - Y;
      }
      if (result == Z) {
        answer[i] = "O";
      } else {
        answer[i] = "X";
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    final _OX퀴즈 solution = new _OX퀴즈();
    solution.solution(new String[]{"3 - 4 = -3", "5 + 6 = 11"});
  }
}
