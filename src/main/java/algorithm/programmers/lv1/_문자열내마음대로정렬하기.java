package algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;

public class _문자열내마음대로정렬하기 {
  public String[] solution(String[] strings, int n) {
    String[] answer = new String[strings.length];
    ArrayList<String> list = new ArrayList<>();

    for (String string : strings) {
      String substring = string.substring(n, n + 1);
      String sortingString = substring + string;
      list.add(sortingString);
    }
    Collections.sort(list);
    for (int i = 0; i < answer.length; i++) {
      answer[i] = list.get(i).substring(1);
    }
    return answer;
  }

  public static void main(String[] args) {
    final _문자열내마음대로정렬하기 solution = new _문자열내마음대로정렬하기();
    solution.solution(new String[]{"sun", "bed", "car"}, 1);
  }
}
