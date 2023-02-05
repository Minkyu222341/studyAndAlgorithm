package com.sparta.algorithm.test;

public class ok {
    public String solution(int num) {
        StringBuilder sb = new StringBuilder();
        String numToString = String.valueOf(num);
        String[] splitNumToString = numToString.split("");
        String[] numBox = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < splitNumToString.length; i++) {
            sb.append(numBox[Integer.parseInt(splitNumToString[i])]);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        ok solution = new ok();
        solution.solution(147);
    }
}
