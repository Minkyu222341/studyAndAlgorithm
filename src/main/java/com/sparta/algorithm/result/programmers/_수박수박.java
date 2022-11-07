package com.sparta.algorithm.result.programmers;

public class _수박수박 {
  public String solution(int n) {
    String answer = "";
    for(int i=0;i<n;i++){
      if(i%2==0){
        answer += "수";
      }else{
        answer +="박";
      }
    }

    return answer;
  }
  public static void main(String[] args) {
    final _수박수박 solution = new _수박수박();
    solution.solution(5);
  }
}
