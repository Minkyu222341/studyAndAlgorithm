package algorithm.result.programmers.lv0;

import java.util.ArrayList;
import java.util.Collections;

public class _연속된수의합 {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];

        int result = 0;
        int startNum = total+50;
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            int count = 0;
            for (int i = startNum; ; i--) {
                if (count == num) {
                    break;
                }
                count++;
                list.add(i);
                result += i;
            }
            if (result == total) {
                break;
            }
            result = 0;
            list.clear();
            startNum--;
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        _연속된수의합 solution = new _연속된수의합();
        solution.solution(3, 0);
    }
}
