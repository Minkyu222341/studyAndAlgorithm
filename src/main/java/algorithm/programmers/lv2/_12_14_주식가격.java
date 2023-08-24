package algorithm.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class _12_14_주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> stock = new LinkedList<>();
        int indexOfQueue = 0;

        initPrice(prices, stock);

        for (int indexOfPrices = 0; indexOfPrices < prices.length; indexOfPrices++) {
            int count = 0;
            indexOfQueue++;
            count = getCount(prices, answer, stock, indexOfQueue, indexOfPrices, count);
            stock.poll();
            answer[indexOfPrices] = count;
        }

        return answer;
    }

    private void initPrice(int[] prices, Queue<Integer> stock) {
        for (int price : prices) {
            stock.offer(price);
        }
    }

    private int getCount(int[] prices, int[] answer, Queue<Integer> stock, int indexOfQueue, int indexOfPrices, int count) {
        for (int indexToCopyOfQueue = indexOfQueue; indexToCopyOfQueue < prices.length; indexToCopyOfQueue++) {
            if (!stock.isEmpty() && prices[indexToCopyOfQueue] >= stock.peek()) {
                count++;
            } else if (!stock.isEmpty() && prices[indexToCopyOfQueue] < stock.peek()) {
                count++;
                answer[indexOfPrices] = count;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        _12_14_주식가격 solution = new _12_14_주식가격();
        solution.solution(new int[]{1, 2, 3, 2, 3});
    }
}
