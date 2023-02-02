package com.sparta.algorithm.result.baekjoon.s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int num = Integer.parseInt(a.split(" ")[0]);

        if (num == 0) {
            System.out.println(0);
        } else {
            String b = br.readLine();
            int limit = Integer.parseInt(a.split(" ")[1]);
            Queue<Integer> queue = new LinkedList<Integer>();

            String[] split = b.split(" ");

            for (String s : split) {
                queue.offer(Integer.parseInt(s));
            }

            int sum = 0;
            int answer = 0;
            System.out.println(queue);
            int length = queue.size();

            for (Integer integer : queue) {
                
            }

            System.out.println(answer);

        }

    }
}
