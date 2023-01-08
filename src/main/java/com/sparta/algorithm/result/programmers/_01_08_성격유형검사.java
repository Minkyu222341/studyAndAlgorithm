package com.sparta.algorithm.result.programmers;

public class _01_08_성격유형검사 {
    public String solution(String[] survey, int[] choices) {
        StringBuilder result = new StringBuilder();
        /**
         * R , T
         * C , F
         * J , M
         * A , N
         * */
        int[] score = new int[4];
        for (int i = 0; i < survey.length; i++) {
            if (survey[i].equals("RT")) {
                if (choices[i] == 1) {
                    score[0] += -3;
                } else if (choices[i] == 2) {
                    score[0] += -2;
                } else if (choices[i] == 3) {
                    score[0] += -1;
                } else if (choices[i] == 5) {
                    score[0] += 1;
                } else if (choices[i] == 6) {
                    score[0] += 2;
                } else if (choices[i] == 7) {
                    score[0] += 3;
                }
            }
            if (survey[i].equals("CF")) {
                if (choices[i] == 1) {
                    score[1] += -3;
                } else if (choices[i] == 2) {
                    score[1] += -2;
                } else if (choices[i] == 3) {
                    score[1] += -1;
                } else if (choices[i] == 5) {
                    score[1] += 1;
                } else if (choices[i] == 6) {
                    score[1] += 2;
                } else if (choices[i] == 7) {
                    score[1] += 3;
                }
            }
            if (survey[i].equals("JM")) {
                if (choices[i] == 1) {
                    score[2] += -3;
                } else if (choices[i] == 2) {
                    score[2] += -2;
                } else if (choices[i] == 3) {
                    score[2] += -1;
                } else if (choices[i] == 5) {
                    score[2] += 1;
                } else if (choices[i] == 6) {
                    score[2] += 2;
                } else if (choices[i] == 7) {
                    score[2] += 3;
                }
            }
            if (survey[i].equals("AN")) {
                if (choices[i] == 1) {
                    score[3] += -3;
                } else if (choices[i] == 2) {
                    score[3] += -2;
                } else if (choices[i] == 3) {
                    score[3] += -1;
                } else if (choices[i] == 5) {
                    score[3] += 1;
                } else if (choices[i] == 6) {
                    score[3] += 2;
                } else if (choices[i] == 7) {
                    score[3] += 3;
                }
            }
            if (survey[i].equals("TR")) {
                if (choices[i] == 1) {
                    score[0] += 3;
                } else if (choices[i] == 2) {
                    score[0] += 2;
                } else if (choices[i] == 3) {
                    score[0] += 1;
                } else if (choices[i] == 5) {
                    score[0] += -1;
                } else if (choices[i] == 6) {
                    score[0] += -2;
                } else if (choices[i] == 7) {
                    score[0] += -3;
                }
            }
            if (survey[i].equals("FC")) {
                if (choices[i] == 1) {
                    score[1] += 3;
                } else if (choices[i] == 2) {
                    score[1] += 2;
                } else if (choices[i] == 3) {
                    score[1] += 1;
                } else if (choices[i] == 5) {
                    score[1] += -1;
                } else if (choices[i] == 6) {
                    score[1] += -2;
                } else if (choices[i] == 7) {
                    score[1] += -3;
                }
            }
            if (survey[i].equals("MJ")) {
                if (choices[i] == 1) {
                    score[2] += 3;
                } else if (choices[i] == 2) {
                    score[2] += 2;
                } else if (choices[i] == 3) {
                    score[2] += 1;
                } else if (choices[i] == 5) {
                    score[2] += -1;
                } else if (choices[i] == 6) {
                    score[2] += -2;
                } else if (choices[i] == 7) {
                    score[2] += -3;
                }
            }
            if (survey[i].equals("NA")) {
                if (choices[i] == 1) {
                    score[3] += 3;
                } else if (choices[i] == 2) {
                    score[3] += 2;
                } else if (choices[i] == 3) {
                    score[3] += 1;
                } else if (choices[i] == 5) {
                    score[3] += -1;
                } else if (choices[i] == 6) {
                    score[3] += -2;
                } else if (choices[i] == 7) {
                    score[3] += -3;
                }
            }
        }

        if (score[0] > 0) {
            result.append("T");
        } else {
            result.append("R");
        }
        if (score[1] > 0) {
            result.append("F");
        } else {
            result.append("C");
        }
        if (score[2] > 0) {
            result.append("M");
        } else {
            result.append("J");
        }
        if (score[3] > 0) {
            result.append("N");
        } else {
            result.append("A");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        _01_08_성격유형검사 solution = new _01_08_성격유형검사();
        solution.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
    }
}
