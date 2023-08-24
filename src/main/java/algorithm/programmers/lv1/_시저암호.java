package algorithm.programmers.lv1;

public class _시저암호 {

  public String solution(String s, int n) {
    String answer = "";
    String[] split = s.split("");
    for (int i = 0; i < split.length; i++) {
      int c = split[i].charAt(0);
      int trans = c + n;
      if (c == 32) {
        trans = 32;
      }

      if (c <= 90 && trans > 90) {
        trans -= 26;
      }
      if (c >= 97 && trans > 122) {
        trans -= 26;
      }

      char intToAscii = (char) trans;
      answer += intToAscii;
    }
    System.out.println(answer);
    return answer;
  }

  public static void main(String[] args) {
    final _시저암호 solution = new _시저암호();
    solution.solution("a B z", 4);
  }
}
