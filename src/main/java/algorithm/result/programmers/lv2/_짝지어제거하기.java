package algorithm.result.programmers.lv2;

import java.util.Stack;

public class _짝지어제거하기 {
  public int solution(String s) {
    int answer = 0;
    Stack<Object> str = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      final char c = s.charAt(i);

      if (!str.empty() && str.peek().equals(c)) {
        str.pop();
      } else {
        str.add(c);
      }
    }
    if (str.isEmpty()) {
      answer = 1;
    }
    return answer;
  }

  public static void main(String[] args) {
    final _짝지어제거하기 solution = new _짝지어제거하기();
    solution.solution("baba");
  }
}
