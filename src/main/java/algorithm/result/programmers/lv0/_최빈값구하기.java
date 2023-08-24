package algorithm.result.programmers.lv0;

import java.util.*;

public class _최빈값구하기 {
    public int solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int flag = -1;
        int max = 0;
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Integer integer : map.keySet()) {
            if (max < map.get(integer)) {
                answer = integer;
                max = map.get(integer);
            } else if (max == map.get(integer)) {
                flag = integer;
            }
        }

        if (map.get(answer) == map.get(flag)) {
            return -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        _최빈값구하기 solution = new _최빈값구하기();
        solution.solution(new int[]{0});
    }
}
