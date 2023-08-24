package algorithm.programmers.lv1;

import java.util.ArrayList;

public class _3진법뒤집기 {
  public int solution(int n) {
    int answer = 0;
    ArrayList<Integer> li = new ArrayList<Integer>();
    //3진법을 만드는 연산
    while(true){
      if(n<3){
        li.add(n);
        break;
      }
      li.add(n%3);
      n = n/3;
    }
    int square =0;
    for(int i=li.size() ; i>0 ; i--){
      answer += li.get(i-1)*((int)Math.pow(3,square));
      square += 1;
    }
    System.out.println(answer);
    return answer;
  }

  public static void main(String[] args) {
    final _3진법뒤집기 solution = new _3진법뒤집기();
    solution.solution(45);
  }
}
