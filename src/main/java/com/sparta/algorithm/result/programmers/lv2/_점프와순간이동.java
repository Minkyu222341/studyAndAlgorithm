package com.sparta.algorithm.result.programmers.lv2;

public class _점프와순간이동 {
    public int solution(int n) {
        int ans = 0;

        while (true) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n - 1;
                ans++;
            }
            if (n == 1) {
                ans++;
                break;
            }
            if (n == 0) {
                break;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        _점프와순간이동 solution = new _점프와순간이동();
        solution.solution(5000);
    }
}
