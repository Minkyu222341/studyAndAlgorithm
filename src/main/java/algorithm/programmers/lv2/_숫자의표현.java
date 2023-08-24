package algorithm.programmers.lv2;

public class _숫자의표현 {
  public int solution(int n) {
    int answer = 1;
    int sum;
    for (int i = 0; i <= n; i++) {
      sum = 0;
      for (int j = i+1; j < n; j++) {
        sum += j;
        if (sum > n) {
          break;
        }
        if (sum == n) {
          answer++;
          break;
        }
      }
    }
    System.out.println(answer);
    return answer;

  }

  public static void main(String[] args) {
    final _숫자의표현 solution = new _숫자의표현();
    solution.solution(15);
  }
}
