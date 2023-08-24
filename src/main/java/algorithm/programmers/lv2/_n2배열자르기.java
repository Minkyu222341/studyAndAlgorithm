package algorithm.programmers.lv2;

import java.util.ArrayList;

public class _n2배열자르기 {
  public int[] solution(int n, long left, long right) {
    int[] answer;

    ArrayList<Integer> list = new ArrayList<>();


    for (long i = left; i <= right ; i++) {
      list.add((int)Math.max(i / n, i % n)+1);
    }
    answer = new int[list.size()];

    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }

    return answer;
  }

  public static void main(String[] args) {
    final _n2배열자르기 solution = new _n2배열자르기();
    solution.solution(3,2,5);
  }
}
