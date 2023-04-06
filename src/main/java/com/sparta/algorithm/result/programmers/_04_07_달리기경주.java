package com.sparta.algorithm.result.programmers;

import java.util.*;

class _04_07_달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            indexMap.put(players[i], i);
        }

        for (String calling : callings) {
            int currentRank = indexMap.get(calling);
            int prevRank = currentRank - 1;

            String prevRankPlayer = players[prevRank];
            int prevRankIndex = indexMap.get(prevRankPlayer);
            players[currentRank] = prevRankPlayer;
            players[prevRankIndex] = calling;
            indexMap.put(calling, prevRankIndex);
            indexMap.put(prevRankPlayer, currentRank);

        }

        return players;
    }

    public static void main(String[] args) {
        _04_07_달리기경주 solution = new _04_07_달리기경주();
        solution.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
    }
}
