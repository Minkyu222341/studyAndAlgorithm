package com.sparta.algorithm.result.programmers;

public class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        StringBuilder card1Sb = new StringBuilder();
        StringBuilder card2Sb = new StringBuilder();
        StringBuilder goalSb = new StringBuilder();

        make(cards1, card1Sb);
        make(cards2, card2Sb);
        make(goal, goalSb);

        String[] cards1Split = card1Sb.toString().split(" ");
        String[] goalSplit = goalSb.toString().split(" ");

        removeSb1FromGoal(cards1Split, goalSplit);

        goalSb.setLength(0);

        make(goalSplit, goalSb);

        System.out.println(goalSb);
        System.out.println(card2Sb);

        if (goalSb.toString().contains(card2Sb)) {
            return "Yes";
        } else {
            return "No";
        }
    }

    private void removeSb1FromGoal(String[] cards1Split, String[] goalSplit) {
        for (int i = 0; i < cards1Split.length; i++) {
            for (int j = 0; j < goalSplit.length; j++) {
                if (cards1Split[i].equals(goalSplit[j])) {
                    goalSplit[j] = goalSplit[j].replace(cards1Split[i], "@");
                }
            }
        }
    }

    private void make(String[] strings, StringBuilder sb) {
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i] + " ");
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
        solution.solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
    }
}
