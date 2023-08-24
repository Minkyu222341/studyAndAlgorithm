package algorithm.programmers.lv1;

public class _숫자문자열과영단어 {
    public int solution(String s) {
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < num.length; i++) {
            s = s.replaceAll(num[i], i + "");
        }
        System.out.println(s);
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        _숫자문자열과영단어 solution = new _숫자문자열과영단어();
        solution.solution("one4seveneight");
    }
}
