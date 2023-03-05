package com.sparta.algorithm.result.programmers;

class _03_05_바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int x = wallpaper.length;
        int y = wallpaper[0].length();

        int left = x, top = y, right = 0, bottom = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    left = Math.min(left, j);
                    top = Math.min(top, i);
                    right = Math.max(right, j);
                    bottom = Math.max(bottom, i);
                }
            }
        }

        int selected = 0; // 선택된 파일의 수
        int distance = 0; // 이동거리의 합
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    selected++;
                    distance += Math.abs(top - i) + Math.abs(left - j);
                }
            }
        }


        answer[0] = top;
        answer[1] = left;
        answer[2] = bottom+1;
        answer[3] = right+1;

        return answer;
    }
}