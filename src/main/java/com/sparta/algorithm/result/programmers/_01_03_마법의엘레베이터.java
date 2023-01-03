package com.sparta.algorithm.result.programmers;

public class _01_03_마법의엘레베이터 {
    public int solution(int storey) {
        int answer = 0;

        while (storey != 0) {
            int num = storey % 10;
            storey = storey / 10;
            if (num > 5) {
                answer += 10 - num;
                storey += 1;
            } else {
                answer += num;
                if (num==5 && storey % 10 >= 5) {
                    storey += 1;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        _01_03_마법의엘레베이터 solution = new _01_03_마법의엘레베이터();
        solution.solution(2554);
    }
}
