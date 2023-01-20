package com.sparta.algorithm.result.programmers.lv1;

import java.util.Arrays;

public class _12_15_로또의최고순위와최저순위 {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int countOfZero = 0;
        int count = 0;
        int[] arrayToErasedZero = Arrays.stream(lottos).filter(i -> i != 0).toArray();

        countOfZero = getCountOfZero(lottos, countOfZero);

        count = countOfContains(win_nums, count, arrayToErasedZero);

        int highestRank  = getRank(count + countOfZero);
        int lowestRank = getRank(count);
        
        answer[0] = highestRank;
        answer[1] = lowestRank;

        return answer;
    }

    private int countOfContains(int[] win_nums, int count, int[] arrayToErasedZero) {
        for (int indexOfLotto = 0; indexOfLotto < arrayToErasedZero.length; indexOfLotto++) {
            for (int indexOfWin = 0; indexOfWin < win_nums.length; indexOfWin++) {
                if (arrayToErasedZero[indexOfLotto] == win_nums[indexOfWin]) {
                    count++;
                }
            }
        }
        return count;
    }

    private int getRank(int count) {
        if (count == 6) {
            return  1;
        } else if (count == 5) {
            return  2;
        } else if (count == 4) {
            return  3;
        } else if (count == 3) {
            return  4;
        } else if (count == 2) {
            return  5;
        } else {
            return  6;
        }
    }

    private int getCountOfZero(int[] lottos, int countOfZero) {
        for (int lotto : lottos) {
            if (lotto == 0) {
                countOfZero++;
            }
        }
        return countOfZero;
    }

    public static void main(String[] args) {
        _12_15_로또의최고순위와최저순위 solution = new _12_15_로또의최고순위와최저순위();
        solution.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
    }
}
