package algorithm.programmers.lv2;

public class _12_24_예상대진표 {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while (true) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
            if (a == b) {
                break;
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        _12_24_예상대진표 solution = new _12_24_예상대진표();
        solution.solution(8, 4, 7);
    }
}
