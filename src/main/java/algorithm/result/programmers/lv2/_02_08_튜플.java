package algorithm.result.programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class _02_08_튜플 {

    public int[] solution(String s) {
        int[] answer;
        HashMap<Integer, Integer> map = new HashMap<>();
        String[] split = s.replaceAll("\\}", "").replaceAll("\\{", "").split(",");



        for (String str : split) {
            try {
                int stringToInteger = Integer.parseInt(str);
                map.put(stringToInteger, map.getOrDefault(stringToInteger, 0) + 1);
            } catch (Exception e) {
            }
        }
        answer = new int[map.size()];
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o2, o1) -> map.get(o1) - map.get(o2));

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        _02_08_튜플 solution = new _02_08_튜플();
//        solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        solution.solution("{{123}}");
    }
}