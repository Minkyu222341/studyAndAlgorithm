package algorithm.result.programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;

public class _01_25_가장큰수 {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        String[] numberToString = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numberToString[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numberToString, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        if (numberToString[0].equals("0")) {
            return 0+"";
        }

        for (String s : numberToString) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        _01_25_가장큰수 solution = new _01_25_가장큰수();
//        solution.solution(new int[]{6, 10, 2});
//        solution.solution(new int[]{3, 30, 34, 5, 9});
        solution.solution(new int[]{0,0,0,0});
    }
}
