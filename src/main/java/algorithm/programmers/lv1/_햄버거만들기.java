package algorithm.programmers.lv1;

class _햄버거만들기 {
  public int solution(int[] ingredient) {
    int answer = 0;
    StringBuilder stringBuilder = new StringBuilder();
    //replaceFirst를 builder로 사용하는게 관건
    for (int i = 0; i < ingredient.length; i++) {
      stringBuilder.append(ingredient[i]);
      if (stringBuilder.length() > 3 && stringBuilder.subSequence(stringBuilder.length() - 4, stringBuilder.length()).equals("1231")) {
        answer++;
        stringBuilder.delete(stringBuilder.length() - 4, stringBuilder.length());
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    final _햄버거만들기 solution = new _햄버거만들기();
    solution.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1, 1, 2, 3, 1, 1, 2, 3, 1,});
  }
}