package algorithm.result.programmers.lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _01_10_실패율 {
    public int[] solution(int N, int[] stages) {
        int[] totalChallengersOfRound = new int[N];

        HashMap<Integer, Double> result = new HashMap<Integer, Double>();
        Map<Integer, Integer> countFailureOfRound = new HashMap<Integer, Integer>();
        int[] answer = new int[N];
        int challenger = 0;

        for (int i = 1; i <= N; i++) {
            for (int stage : stages) {
                if (i <= stage) {
                    challenger++;
                }
            }
            totalChallengersOfRound[i - 1] = challenger;
            challenger = 0;
        }
        for (int stage : stages) {
            if (stage > N) {
                countFailureOfRound.put(stage - 1, countFailureOfRound.getOrDefault(stage - 1, 0));
            } else {
                countFailureOfRound.put(stage, countFailureOfRound.getOrDefault(stage, 0) + 1);
            }
        }
        for (int i = 0; i < N; i++) {
            try {
                result.put(i + 1, (double) countFailureOfRound.get(i + 1) / (double) totalChallengersOfRound[i]);
            } catch (NullPointerException e) {
                result.put(i + 1, 0.0);
            }
        }
        ArrayList<Integer> keySet = new ArrayList<>(result.keySet());
        keySet.sort((o1, o2) -> result.get(o2).compareTo(result.get(o1)));

        int count = 0;
        for (Integer integer : keySet) {
            answer[count] = integer;
            count++;
        }

        return answer;
    }

    public static void main(String[] args) {
        _01_10_실패율 solution = new _01_10_실패율();
//        solution.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        solution.solution(4, new int[]{4, 4, 4, 4, 4});
    }
}
