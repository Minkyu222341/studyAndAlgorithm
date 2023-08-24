package algorithm.programmers.lv1;

public class _푸드파이트대회 {
  public String solution(int[] food) {
    StringBuffer sb = new StringBuffer();

    for (int i = 1; i < food.length; i++) {
      int count = 0;
      int divide = food[i] / 2;
      if (food[i] % 2 == 0 || divide >= 1) {
        while (true) {
          if (count == divide) {
            break;
          }
          count++;
          sb.append(i);
        }
      }
    }
    String answer = sb.toString();
    return answer+"0"+sb.reverse();
  }

  public static void main(String[] args) {
    final _푸드파이트대회 solution = new _푸드파이트대회();
    solution.solution(new int[]{1,7,1,2});
  }
}
