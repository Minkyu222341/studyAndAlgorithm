package algorithm.result.programmers.lv2;

public class _01_24_땅따먹기 {
    int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }

        for (int i = 0; i < land[0].length; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        _01_24_땅따먹기 solution = new _01_24_땅따먹기();
        solution.solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}});
//        solution.solution(new int[][]{{1, 1, 1, 1}, {2, 2, 2, 3}, {3, 3, 3, 6}, {4, 4, 4, 7}});
    }
}
