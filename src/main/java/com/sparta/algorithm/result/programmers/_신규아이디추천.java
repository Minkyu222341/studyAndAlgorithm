package com.sparta.algorithm.result.programmers;

import java.util.regex.PatternSyntaxException;

/**
 * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
 * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
 * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
 * 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 */
public class _신규아이디추천 {
    public String solution(String new_id) {
        String idToLowerCase = new_id.toLowerCase();
        int count = 0;
        int flag = 1;
        int length = idToLowerCase.length();

        while (true) {
            if (idToLowerCase.length() - 1 < count) {
                break;
            }
            int c = idToLowerCase.charAt(count);
            System.out.println(c);
            if (c < 45 || c > 57 && c != 95 && c < 96) {
                try {
                    idToLowerCase = idToLowerCase.replace((String.valueOf(idToLowerCase.charAt(count))), "");
                    count--;
                } catch (PatternSyntaxException e) {
                    idToLowerCase = idToLowerCase.replace((String.valueOf("\\" + idToLowerCase.charAt(count))), "");
                    count--;
                }
            }else if (c == 123 || c == 125 || c==47 || c==126) {
                idToLowerCase = idToLowerCase.replace(String.valueOf(idToLowerCase.charAt(count)), "");
                count--;
            }
            count++;
            flag++;
            if (flag > length) {
                break;
            }
        }
        //특수문자제거
//        idToLowerCase = idToLowerCase.replaceAll("[^a-z0-9-_.]","");
        System.out.println(idToLowerCase);
        while (idToLowerCase.indexOf("..") != -1) {
            idToLowerCase = idToLowerCase.replace("..", ".");
        }

        while (true) {
            if (idToLowerCase.indexOf(".") == 0) {
                idToLowerCase = idToLowerCase.substring(1);
            }
            if (idToLowerCase.length() >= 2 && String.valueOf(idToLowerCase.charAt(idToLowerCase.length() - 1)).equals(".")) {
                idToLowerCase = idToLowerCase.substring(0, idToLowerCase.length() - 1);
            }
            if (idToLowerCase.length() == 0 || idToLowerCase.indexOf(".") != 0 && !String.valueOf(idToLowerCase.charAt(idToLowerCase.length() - 1)).equals(".")) {
                break;
            }
        }
        //앞과뒤의 점 제거
//        idToLowerCase = idToLowerCase.replaceAll("^(\\.)|(\\.)$","");


        if (idToLowerCase.isEmpty()) {
            idToLowerCase += "a";
        }

//15자로 만들고나서 앞과뒤의 점이 있다면 제거
        if (idToLowerCase.length() > 15) {
            idToLowerCase = idToLowerCase.substring(0, 15).replaceAll("(\\.)$", "");;
        }


        while (idToLowerCase.indexOf(".") == idToLowerCase.length() - 1) {
            idToLowerCase = idToLowerCase.substring(0, idToLowerCase.length() - 1);
        }
        while (idToLowerCase.length() < 3) {
            if (idToLowerCase.length() == 1) {
                idToLowerCase += idToLowerCase;
            } else {
                idToLowerCase += idToLowerCase.substring(idToLowerCase.length() - 1);
            }
        }
        System.out.println(idToLowerCase);
        return idToLowerCase;
    }

    public static void main(String[] args) {
        _신규아이디추천 solution = new _신규아이디추천();
        solution.solution("......a......a......a.....");
    }
}
