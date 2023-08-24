package algorithm.result.programmers.lv2;

import java.util.*;

public class _01_26_다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> onGoing = new LinkedList<>();
        int currentWeight = 0;
        int index = 0;

        while (index != truck_weights.length) {
            // 다리위에 트럭이 꽉차 있을때 통과시켜줌
            if (onGoing.size() == bridge_length && !onGoing.isEmpty()) {
                currentWeight -= onGoing.poll();
            } else if (currentWeight + truck_weights[index] > weight) {
                //다리위의 제한하중이 넘어갈 경우 큐에 0값을 넣어주고 시간 추가
                onGoing.offer(0);
                time++;
            } else {
                // 그 외의 경우는 트럭 출발
                onGoing.offer(truck_weights[index]);
                currentWeight += truck_weights[index++];
                time++;
            }
        }
        System.out.println(time+bridge_length);

        // 마지막 트럭이 다리에 올라온 순간 -> 반복문 탈출 따라서 최종값을 구하기 위해서는 ->
        // 현재까지 걸린시간 + 마지막 트럭이 탈출하기까지 걸리는 시간(다리의 길이)
        return time+bridge_length;
    }


    public static void main(String[] args) {
        _01_26_다리를지나는트럭 solution = new _01_26_다리를지나는트럭();
//        solution.solution(2, 10, new int[]{7, 4, 5, 6});
//        solution.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        solution.solution(100, 100, new int[]{10});
    }
}
