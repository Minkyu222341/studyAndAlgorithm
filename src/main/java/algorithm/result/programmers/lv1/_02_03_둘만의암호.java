package algorithm.result.programmers.lv1;

public class _02_03_둘만의암호 {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char alphabet = s.charAt(i);
            for (int j = 0; j < index; j++) {
                alphabet++;
                if (alphabet > 122) {
                    alphabet = (char) (alphabet - 26);
                }
                if (skip.contains(""+alphabet)) {
                    j--;
                }
            }

            sb.append(alphabet);
        }
        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        _02_03_둘만의암호 solution = new _02_03_둘만의암호();
//        solution.solution("aukks","wbqd",5);
        solution.solution("ybcde", "az", 1);
    }
}
