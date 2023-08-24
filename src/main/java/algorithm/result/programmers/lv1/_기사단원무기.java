package algorithm.result.programmers.lv1;

//number - 기사의 머릿수
//limit - 공격력 제한
//power - 공격력 제한을 넘긴 기사가 사용할 공격력의 무기
// 기사는 본인의 인덱스 +1의 약수의 갯수 만큼의 공격력을 가진 무기를 구매함
// 무기를 제작하는데 필요한 철은 공격력 1당 1키로그램이다.
// 소모되는 철의 합을 구하라
public class _기사단원무기 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] knights = new int[number];
        int damage;
        for (int i = 1; i <= knights.length; i++) {
            damage = 0;
            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                if (i % j == 0) {
                    damage++;
                    if (i / j != j) {
                        damage++;
                    }
                }
            }
            if (damage > limit) {
                answer += power;
            } else {
                answer += damage;
            }

        }
        System.out.println(answer);
        return answer;

    }

    public static void main(String[] args) {
        _기사단원무기 solution = new _기사단원무기();
        solution.solution(10, 3, 2);
    }
}
