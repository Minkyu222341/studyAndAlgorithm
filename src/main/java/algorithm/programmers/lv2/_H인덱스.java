package algorithm.programmers.lv2;

import java.util.Arrays;
import java.util.Collections;

class _H인덱스 {
  public int solution(int[] citations) {
    int count = 0;
    Integer[] integers = Arrays.stream(citations).boxed().toArray(Integer[]::new);
    Arrays.sort(integers,Collections.reverseOrder());
    while (true) {
      for (Integer integer : integers) {
        if (count >= integer) {
          return count;
        }
        if (count >= integers.length) {
          return count;
        }
        count++;
      }
    }
  }

  public static void main(String[] args) {
    final _H인덱스 solution = new _H인덱스();
    solution.solution(new int[]{10,10,10,10,10});
  }
}
