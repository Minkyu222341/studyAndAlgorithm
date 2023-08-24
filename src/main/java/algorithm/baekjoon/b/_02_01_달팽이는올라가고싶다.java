package algorithm.baekjoon.b;

import java.util.Scanner;

public class _02_01_달팽이는올라가고싶다 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int lastDay = c - a;
        int day = lastDay / (a - b);

        if (lastDay%(a-b) == 0) {
            System.out.println(day += 1);
        } else {
            System.out.println(day += 2);
        }

    }
}
