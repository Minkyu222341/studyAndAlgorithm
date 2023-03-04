class _03_24_덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int valid = 0;

        for (int num : section) {
            if (num > valid) {
                valid = m+ num-1;
                answer++;
            }
        }
        return answer;
    }
}
