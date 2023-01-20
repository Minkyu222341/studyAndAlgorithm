package com.sparta.algorithm.result.programmers.lv2;

import java.util.*;

public class _12_13_프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int priority : priorities) {
            queue.offer(priority);
        }

        while (queue.size() > 0) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {
                    System.out.println(queue);
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    queue.poll();
                    answer++;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        _12_13_프린터 solution = new _12_13_프린터();
        solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    }
}
