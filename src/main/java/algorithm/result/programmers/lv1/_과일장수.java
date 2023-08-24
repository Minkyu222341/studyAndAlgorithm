package algorithm.result.programmers.lv1;

import java.util.*;

public class _과일장수 {
  public int solution(int k, int m, int[] score) {
    int answer = 0;
    ArrayList<Integer> list = new ArrayList<>();
    Arrays.sort(score);

    for (int i = score.length - 1; i > 0; i -= m) {
      if (i+1 >= m) {
        for (int j = i; j > i - m; j--) {
          list.add(score[j]);
        }
        Optional<Integer> min = list.stream().min(Integer::compareTo);
        answer += min.get() * list.size();
        list.clear();
      } else {
        break;
      }
    }
    System.out.println(answer);
    return answer;
  }

  public static void main(String[] args) {
    final _과일장수 solution = new _과일장수();
    solution.solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2});
  }
}
