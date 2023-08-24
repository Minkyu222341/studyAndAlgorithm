package algorithm.result.programmers.lv1;

public class _12_12_다트게임 {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        int idx = 0;
        String receive = "";
        int num;

        for (int i = 0; i < dartResult.length(); i++) {
            char dart = dartResult.charAt(i);
            if (dart >= '0' && dart <= '9') {
                receive += String.valueOf(dart);
            } else if (dart == 'S' || dart == 'D' || dart == 'T') {
                num = Integer.parseInt(receive);
                if (dart == ('S')) {
                    num = (int) Math.pow(num, 1);
                } else if (dart == ('D')) {
                    num = (int) Math.pow(num, 2);
                } else if (dart == ('T')) {
                    num = (int) Math.pow(num, 3);
                }
                score[idx] = num;
                idx++;
                receive = "";
            }

            if (dart == ('#')) {
                score[idx-1] *= -1;
            } else if (dart == ('*')) {
                score[idx-1] *= 2;
                if (idx > 1) {
                    score[idx - 2] *= 2;
                }
            }
        }
        for (int i : score) {
            answer += i;
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        _12_12_다트게임 solution = new _12_12_다트게임();
        solution.solution("1S*2T*3S");
    }
}
