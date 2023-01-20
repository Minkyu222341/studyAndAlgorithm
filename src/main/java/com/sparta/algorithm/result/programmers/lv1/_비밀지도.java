package com.sparta.algorithm.result.programmers.lv1;

public class _비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String temp;
        for (int i = 0; i < n; i++) {
            String binary1 = Integer.toBinaryString(arr1[i]);
            String binary2 = Integer.toBinaryString(arr2[i]);
            binary1 = "0".repeat(n - binary1.length()) + binary1;
            binary2 = "0".repeat(n - binary2.length()) + binary2;

            String[] split1 = binary1.split("");
            String[] split2 = binary2.split("");
            temp = "";
            for (int j = 0; j < split1.length; j++) {
                if (split1[j].equals("1") || split2[j].equals("1")) {
                    temp += "#";
                } else {
                    temp += " ";
                }
            }
            answer[i] = temp;
        }

        for (String s : answer) {
            System.out.println(s);
        }
        return answer;
    }

    public static void main(String[] args) {
        _비밀지도 solution = new _비밀지도();
        solution.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
    }
}
