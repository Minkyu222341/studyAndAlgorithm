package com.sparta.algorithm.result.programmers.lv2;

import java.util.*;

public class _01_19_괄호회전하기 {
    public int solution(String s) {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            s = move(s);
            String[] brackets = s.split("");
            if (validation(stack,brackets)) {
                answer++;
            }
            stack.clear();
        }
        return answer;
    }

    private boolean validation(Stack<String>stack,String[] brackets) {
        for (String bracket : brackets) {
            if (stack.isEmpty()) {
                stack.push(bracket);
            }else if (bracket.equals("[") || bracket.equals("{") || bracket.equals("(")) {
                stack.push(bracket);
            } else {
                if (bracket.equals("]")) {
                    if (stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        stack.push(bracket);
                    }
                } else if (bracket.equals("}")) {
                    if (stack.peek().equals("{")) {
                        stack.pop();
                    } else {
                        stack.push(bracket);
                    }
                } else if (bracket.equals(")")) {
                    if (stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        stack.push(bracket);
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    private String move(String s) {
        s = s.substring(1) + s.charAt(0);
        return s;
    }


    public static void main(String[] args) {
        _01_19_괄호회전하기 solution = new _01_19_괄호회전하기();
//        solution.solution("}]()[{");
        solution.solution("[](){}");
//        solution.solution("[)(]");
//        solution.solution("}}}");
    }
}
