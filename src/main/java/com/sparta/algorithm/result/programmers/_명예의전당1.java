package com.sparta.algorithm.result.programmers;

import java.util.PriorityQueue;

public class _명예의전당1 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int count = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : score) {
            if (queue.size() >= k) {
                if (queue.peek() <= i) {
                    queue.poll();
                    queue.offer(i);
                }
            } else {
                queue.offer(i);
            }
            answer[count] = queue.peek();
            count++;
        }
        return answer;
    }

    public static void main(String[] args) {
        _명예의전당1 solution = new _명예의전당1();
        solution.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
    }
}
