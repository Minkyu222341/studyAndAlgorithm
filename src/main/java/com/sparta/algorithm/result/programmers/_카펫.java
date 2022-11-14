package com.sparta.algorithm.result.programmers;

public class _카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; // 가로 , 세로
        int block = brown + yellow; // 전체 블럭의 갯수

        for (int i = 3; i < block; i++) { // 가운데에 다른색 블럭을 가질 수 있는 최소의 가로세로 길이 3
            int divide = block / i;
            if (block % i == 0 && divide >= 3) { //가운데의 블럭을 감싸는 형태가 되어야 하므로
                int col = Math.max(i, divide); // 가로의 길이가 세로의 길이보다 길다.
                int row = Math.min(i, divide);
                int yellowBlock = (col - 2) * (row - 2);

                if (yellow == yellowBlock) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _카펫 solution = new _카펫();
        solution.solution(24,24);
    }
}
