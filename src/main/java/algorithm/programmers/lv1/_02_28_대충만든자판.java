package algorithm.programmers.lv1;

import java.util.HashMap;

public class _02_28_대충만든자판 {
  public int[] solution(String[] keymap, String[] targets) {
    int[] answer = new int[targets.length];
    HashMap<String, Integer> map = new HashMap<>();

    makeValidationMap(keymap, map);

    validation(targets, answer, map);

    return answer;
  }

  private static void validation(String[] targets, int[] answer, HashMap<String, Integer> map) {
    for (int i = 0; i < targets.length; i++) {
      String[] split = targets[i].split("");
      int sum = 0;
      try {
        for (String key : split) {
          sum += map.get(key) + 1;
        }
        answer[i] = sum;
      } catch (NullPointerException e) {
        answer[i] = -1;
      }
    }
  }

  private static void makeValidationMap(String[] keymap, HashMap<String, Integer> map) {
    for (int i = 0; i < keymap.length; i++) {
      String[] split = keymap[i].split("");
      for (int index = 0; index < split.length; index++) {
        if (map.get(split[index]) == null) {
          map.put(split[index], index);
        }

        if (map.get(split[index]) > index) {
          map.put(split[index], index);
        }

      }
    }
  }

  public static void main(String[] args) {
    _02_28_대충만든자판 solution = new _02_28_대충만든자판();
//    solution.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"});
    solution.solution(new String[]{"AA"}, new String[]{"B"});
//    solution.solution(new String[]{"AGB", "BSSS"}, new String[]{"AGZ", "BSSS"});
  }

}
