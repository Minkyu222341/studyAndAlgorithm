package algorithm.programmers.lv1;

public class _모의고사 {
  public int[] solution(int[] answers) {
    int[] answer;
    int[] sufoja1 = {1, 2, 3, 4, 5};
    int[] sufoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] sufoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    int[] result = new int[3];
    int count = 0;

    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == sufoja1[i % sufoja1.length]) {
        result[0]++;
      }
      if (answers[i] == sufoja2[i % sufoja2.length]) {
        result[1]++;
      }
      if (answers[i] == sufoja3[i % sufoja3.length]) {
        result[2]++;
      }
    }
    int maxValue = result[0];
    for (int i = 0; i < result.length; i++) {
      if (result[i] >= maxValue) {
        maxValue = result[i];
      }
    }

    for (int i = 0; i < 3; i++) {
      if (result[i] == maxValue) {
        count++;
      }
    }
    answer = new int[count];
    int flag= 0;
    for (int i = 0; i < 3; i++) {
      if(result[i]==maxValue){
        answer[flag] = i+1;
        flag++;
      }
    }
    for (int i : answer) {
      System.out.println(i);
    }
    return answer;
  }

  public static void main(String[] args) {
    final _모의고사 solution = new _모의고사();
    solution.solution(new int[]{3, 3, 2, 1, 5});
  }
}
