package algorithm.programmers.lv1;

import java.util.HashMap;

public class _완주하지못한선수 {
  public String solution(String[] participant, String[] completion) {
    String answer = "";
    HashMap<String,Integer> map  = new HashMap<String,Integer>();
    //getOrDefault를 사용해서 중복검사를 해주는게 핵심
    //map에 값을 넣을때 같은 name이 key에 들어가게되면 getOrDefault로 value만 증가시켜준다
    for(String name:participant){
      map.put(name,map.getOrDefault(name,0)+1);
    }
    //위와 같은 방식으로 map에 값을 넣을때 key에 같은name이 있다면 value를 지정한 대로 연산해준다
    for(String name:completion){
      map.put(name,map.getOrDefault(name,0)-1);
    }

    //반복문에 keyset(key의값)을사용해 String에 각 n번째의 키값을 스트링에담고 value를 가져와서 비교하기위해
    //map.get(key)로 중복체크를해서 +-가 된 값을 가져온다음 조건에 해당하는 값을 리턴해준다
    for(String key:map.keySet()){
      if(map.get(key)>0){
        answer = key;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    _완주하지못한선수 solution = new _완주하지못한선수();
    solution.solution(new String[]{"leo","kiki","eden"},new String[]{"eden","kiki"});
  }
}
