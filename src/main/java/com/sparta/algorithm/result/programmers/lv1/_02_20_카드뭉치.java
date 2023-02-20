package com.sparta.algorithm.result.programmers.lv1;

public class _02_20_카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        int card1Index = 0;
        int card2Index = 0;

        for (int i = 0; i < goal.length; i++) {
            if (goal[i].equals(cards1[card1Index])) {
                card1Index++;
                if (card1Index > cards1.length - 1) {
                    card1Index = cards1.length - 1;
                }
            } else if (goal[i].equals(cards2[card2Index])) {
                card2Index++;
                if (card2Index > cards2.length - 1) {
                    card2Index = cards2.length - 1;
                }
            } else {
                return "No";
            }
        }

        return "Yes";
    }

    public static void main(String[] args) {
        _02_20_카드뭉치 solution = new _02_20_카드뭉치();
//        solution.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
        solution.solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
    }
}
