package algorithm.programmers.lv1;

import java.util.Arrays;

/**
 * packageName    : algorithm.programmers.lv1
 * fileName       : Solution
 * author         : MinKyu Park
 * date           : 2024-10-21
 * description    : [PCCE 기출문제] 9번 / 지폐접기
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-21        MinKyu Park       최초 생성
 */
public class _지폐접기 {

	public int solution(int[] wallet, int[] bill) {
		int answer = 0;

		while (true) {
			Arrays.sort(wallet);
			Arrays.sort(bill);

			if (bill[0] <= wallet[0] &&  bill[1] <= wallet[1]) {
				break;
			}

			if (bill[0] > bill[1]) {
				bill[0] = bill[0] / 2;
			} else if (bill[1] > bill[0]) {
				bill[1] = bill[1] / 2;
			}

			answer++;
		}
		return answer;
	}

	public static void main(String[] args) {
		_지폐접기 solution = new _지폐접기();
		//result = 1
		solution.solution(new int[] {30, 15}, new int[] {26, 17});
		//result = 4
		// solution.solution(new int[] {50, 50}, new int[] {100, 241});

	}
}
