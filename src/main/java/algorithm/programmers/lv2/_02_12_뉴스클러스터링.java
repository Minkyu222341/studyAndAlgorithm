package algorithm.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;

// 97 ~ 122
public class _02_12_뉴스클러스터링 {

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> str1Box = new ArrayList<>();
        ArrayList<String> str2Box = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();

        make(str1, str1Box);
        make(str2, str2Box);

        for (String str : str1Box) {
            if (str2Box.remove(str)) {
                intersection.add(str);
            }
            union.add(str);
        }

        union.addAll(str2Box);

        if (intersection.size() == 0 && union.size() == 0) {
            return 65536;
        }

        return (int) ((double) intersection.size() / (double) union.size() * 65536);
    }

    private void make(String str2, ArrayList<String> box) {
        for (int i = 0; i < str2.length() - 1; ++i) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);

            if (first >= 'a' && first <= 'z' &&
                    second >= 'a' && second <= 'z') {
                box.add(first + "" + second);
            }
        }
        Collections.sort(box);
    }


    public static void main(String[] args) {
        _02_12_뉴스클러스터링 solution = new _02_12_뉴스클러스터링();
//        solution.solution("FRANCE", "french");
//        solution.solution("handshake", "shake hands");
        solution.solution("E=M*C^2", "e=m*c^2");
//        solution.solution("aa1+aa2", "AAAA12");
    }
}