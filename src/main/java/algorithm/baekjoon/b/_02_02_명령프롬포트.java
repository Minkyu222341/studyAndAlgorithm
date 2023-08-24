package algorithm.baekjoon.b;

import java.util.Scanner;

//3
//config.sys
//config.inf
//configures

public class _02_02_명령프롬포트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amount = Integer.parseInt(sc.nextLine());
        String firstFileName = sc.nextLine();
        String[] temp = new String[firstFileName.length()];
        StringBuilder sb = new StringBuilder();

        makeToArray(firstFileName, temp);

        validation(sc, amount, temp);

        makeResult(temp, sb);
    }

    static void makeResult(String[] temp, StringBuilder sb) {
        for (String s : temp) {
            sb.append(s);
        }
        System.out.println(sb);
    }

    static void validation(Scanner sc, int amount, String[] temp) {
        for (int i = 1; i < amount; i++) {
            String fileName = sc.nextLine();
            String[] split = fileName.split("");
            for (int index = 0; index < split.length; index++) {
                if (!temp[index].equals(split[index])) {
                    temp[index] = "?";
                }
            }

        }
    }

    static void makeToArray(String firstFileName, String[] temp) {
        String[] firstFileNameSplit = firstFileName.split("");
        for (int i = 0; i < firstFileNameSplit.length; i++) {
            temp[i] = firstFileNameSplit[i];
        }
    }
}
