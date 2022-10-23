package com.sparta.algorithm.result;

import java.util.HashMap;

public class _폰켓몬 {
  public int solution(int[] nums) {
    int answer = 0;
    int len = nums.length / 2;
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int pon : nums)
      map.put(pon, map.getOrDefault(pon, 0) + 1);

    for (int pon : map.keySet()) {
      answer += 1;
    }

    return (len > map.size()) ? answer : len;
  }


  public static void main(String[] args) {
    final _폰켓몬 solution = new _폰켓몬();
    solution.solution(new int[]{3,1,2,3});
  }
}
