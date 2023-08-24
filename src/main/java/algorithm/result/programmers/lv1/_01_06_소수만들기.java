package algorithm.result.programmers.lv1;

import java.util.ArrayList;

public class _01_06_소수만들기 {
    public int solution(int[] nums) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (i + 2 >= nums.length) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                for (int h = j + 1; h < nums.length; h++) {
                    list.add(nums[i] + nums[j] + nums[h]);
                }
            }
        }

        for (Integer i : list) {
            int count = 2;
            answer++;
            while (count < i) {
                if (i % count == 0) {
                    answer--;
                    break;
                }
                count++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        _01_06_소수만들기 solution = new _01_06_소수만들기();
        solution.solution(new int[]{1, 2, 3, 4});
    }
}
