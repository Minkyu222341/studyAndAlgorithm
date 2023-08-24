package algorithm.result.programmers.lv1;

public class _옹알이2 {
  public int solution(String[] babbling) {
    int answer = 0;

    String aya = "aya";
    String ye = "ye";
    String woo = "woo";
    String ma = "ma";

    for (String s : babbling) {
      if (!s.contains(aya+aya)&&s.contains(aya)) {
        s = s.replace(aya, ".");
      }
      if (!s.contains(ye+ye)&&s.contains(ye)) {
        s = s.replace(ye, ".");
      }
      if (!s.contains(woo+woo)&&s.contains(woo)) {
        s = s.replace(woo, ".");
      }
      if (!s.contains(ma+ma)&&s.contains(ma)) {
        s = s.replace(ma, ".");
      }
      s = s.replace(".", "");
      if (s.equals("")) {
        answer++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    final _옹알이2 solution = new _옹알이2();
    solution.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa","wooyemawooye"});
  }
}
