package algorithm.result.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class _12_08_1차캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        for (String city : cities) {
            String cityToLowerCase = city.toLowerCase();
            if (queue.size() > cacheSize) {
                queue.poll();
            }

            if (queue.contains(cityToLowerCase)) {
                queue.remove(cityToLowerCase);
                answer -= 4;
            }
            queue.offer(cityToLowerCase);
            answer += 5;
        }

        return answer;
    }

    public static void main(String[] args) {
        _12_08_1차캐시 solution = new _12_08_1차캐시();
        solution.solution(2,new String[]{"Jeju", "Pangyo", "NewYork", "newyork"});
    }
}
