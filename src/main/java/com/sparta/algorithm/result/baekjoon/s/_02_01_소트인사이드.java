package com.sparta.algorithm.result.baekjoon.s;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _02_01_소트인사이드 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        StringBuilder sb = new StringBuilder();

        ArrayList<String> strings = new ArrayList<>();
        String[] split = a.split("");
        for (String s : split) {
            strings.add(s);
        }
        Collections.sort(strings,Collections.reverseOrder());

        for (String string : strings) {
            sb.append(string);
        }
        System.out.println(sb);
    }
}
