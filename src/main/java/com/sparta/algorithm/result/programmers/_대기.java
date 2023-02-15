package com.sparta.algorithm.result.programmers;

public class _대기 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int count = 0;

        for (int i = 0; i < query.length; i++) {
            String[] splitQuery = query[i].split(" ");
            String lang = splitQuery[0];
            String position = splitQuery[2];
            String skillLevel = splitQuery[4];
            String food = splitQuery[6];
            String score = splitQuery[7];

            for (int j = 0; j < info.length; j++) {
                if (info[j].contains(lang) || lang.equals("-")) {
                    if (info[j].contains(position) || position.equals("-")) {
                        if (info[j].contains(skillLevel) || skillLevel.equals("-")) {
                            if (info[j].contains(food) || food.equals("-")) {
                                String[] splitInfo = info[j].split(" ");
                                int infoScore = Integer.parseInt(splitInfo[splitInfo.length - 1]);
                                int queryScore = Integer.parseInt(score);
                                if (infoScore >= queryScore) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
            // 인포 조회 끝
            answer[i] = count;
            count = 0;
            
        }
        return answer;
    }


    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        _대기 solution = new _대기();
        solution.solution(info, query);
    }
}

