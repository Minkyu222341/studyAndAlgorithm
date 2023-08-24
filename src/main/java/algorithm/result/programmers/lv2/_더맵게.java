package algorithm.result.programmers.lv2;

import java.util.PriorityQueue;

public class _더맵게 {
  public int solution(int[] scoville, int K) {
    int answer = 0;

    PriorityQueue<Integer> queue = new PriorityQueue();

    for (int i : scoville) {
      queue.offer(i);
    }

    while (queue.peek() <= K) {
      if (queue.size()==1) {
        return -1;
      }

      int min = queue.poll();
      int min2 = queue.poll();
      queue.offer(min + (min2 * 2));
      answer++;
    }
    System.out.println(answer);
    return answer;
  }

  public static void main(String[] args) {
    final _더맵게 solution = new _더맵게();
    solution.solution(new int[] {1, 2, 3, 9, 10, 12},7);
  }
}
