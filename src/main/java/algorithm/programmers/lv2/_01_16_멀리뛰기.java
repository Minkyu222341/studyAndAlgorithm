package algorithm.programmers.lv2;

public class _01_16_멀리뛰기 {
    public long solution(int n) {
        int answer = 0;
        int first = 1;
        int second = 1;

        if (n == 1) return 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                answer = (first + second) % 1234567;
                second = answer;
            } else {
                answer = (first + second) % 1234567;
                first = answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _01_16_멀리뛰기 solution = new _01_16_멀리뛰기();
        solution.solution(4);
    }
}
