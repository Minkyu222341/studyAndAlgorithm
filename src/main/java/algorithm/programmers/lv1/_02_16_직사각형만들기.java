package algorithm.programmers.lv1;

import java.util.HashMap;

public class _02_16_직사각형만들기 {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();

        for (int i = 0; i < v.length; i++) {
            xMap.put(v[i][0], xMap.getOrDefault(v[i][0], 0) + 1);
            yMap.put(v[i][1], yMap.getOrDefault(v[i][1], 0) + 1);
        }

        for (Integer key : xMap.keySet()) {
            if (xMap.get(key) == 1) {
                answer[0] = key;
            }
        }
        for (Integer key : yMap.keySet()) {
            if (yMap.get(key) == 1) {
                answer[1] = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        _02_16_직사각형만들기 solution = new _02_16_직사각형만들기();
//        solution.solution(new int[][]{{1, 4}, {3, 4}, {3, 10}});
        solution.solution(new int[][]{{1, 1}, {2, 2}, {1, 2}});
    }
}
