package algorithm.programmers.lv2;

import java.util.HashSet;

public class _끝말잇기 {
    public int[] solution(int n, String[] words) {

        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        String last = words[0].substring(words[0].length() - 1);
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            int people = i % n;
            int turn = i / n;
            String first = words[i].substring(0,1);
            if (!first.equals(last) || set.contains(words[i])) {
                answer[0] = people + 1;
                answer[1] = turn + 1;
                break;
            }
            set.add(words[i]);
            last = words[i].substring(words[i].length() - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        _끝말잇기 solution = new _끝말잇기();
        solution.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
    }

}
