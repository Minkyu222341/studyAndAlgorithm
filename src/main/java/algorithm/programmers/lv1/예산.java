package algorithm.programmers.lv1;

import java.util.Arrays;

public class 예산 {
  public int solution(int[] d, int budget) {
    int answer = 0;
    Arrays.sort(d);
    for (int i : d) {
      if (budget < i) {
        break;
      }
      budget -= i;
      answer++;
    }
    return answer;
  }

  public static void main(String[] args) {
    final 예산 solution = new 예산();
    solution.solution(new int[]{1, 3, 2,5, 4},9);
  }
}
