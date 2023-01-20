package com.sparta.algorithm.result.programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int count = 0;
        int number = 0;
        int pileUp = 0;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int progress : progresses) {
            queue.offer(progress);
        }

        while (true) {
            int top = queue.peek() + speeds[number] * count;
            if (top < 100) {
                count++;
                if (pileUp != 0) {
                    list.add(pileUp);
                }
                pileUp = 0;
            }
            if (top >= 100) {
                queue.poll();
                pileUp++;
                number++;
            }
            if (queue.isEmpty()) {
                list.add(pileUp);
                break;
            }
        }
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }

        return answer;
    }

    public static void main(String[] args) {
        _기능개발 solution = new _기능개발();
        solution.solution(new int[]{93, 30, 55}, new int[]{1, 30,5});
    }
}
