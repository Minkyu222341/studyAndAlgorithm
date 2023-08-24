package algorithm.result.programmers.lv2;

public class _01_30_행렬의곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int length = 0; length < arr1.length; length++) {
            for (int column = 0; column < arr2[0].length; column++) {
                for (int row = 0; row < arr1[0].length; row++) {
                    answer[length][column] += arr1[length][row] * arr2[row][column];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        _01_30_행렬의곱셈 solution = new _01_30_행렬의곱셈();
        solution.solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}});
    }

}

/**
 * 2,3,2       5,4,3
 * 4,2,4       2,4,1
 * 3,1,4       3,1,1
 */