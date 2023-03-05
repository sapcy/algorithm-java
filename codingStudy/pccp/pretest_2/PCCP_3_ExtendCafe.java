package codingStudy.pccp.pretest_2;

import java.util.*;

class PCCP_3_ExtendCafe {
    public static void main(String[] args) {
        int[] menu = {5, 12, 30};
        int[] order = {1, 2, 0, 1};
        int k = 3;
        System.out.println(solution(menu, order, k));
    }

    public static int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        int orderIndex = -1;
        int nowTime = 0;
        int nowMakingTime = 0;
        int fullMakingTime = 0;
        Queue<Integer> orderQueue = new LinkedList<>();

        while (true) {
            // 새로운 손님 방문시
            if (nowTime%k == 0 && orderIndex+1 < order.length) {
                orderIndex++;
                orderQueue.offer(order[orderIndex]);
                answer = Math.max(answer, orderQueue.size());
            }

            // 제조하지 않을 때
            if (nowMakingTime == 0 && orderQueue.size() > 0) {
                fullMakingTime = menu[orderQueue.peek()];
                nowMakingTime = 1;
            }

            // 제조 중일 때
            if (fullMakingTime > 0) {
                if (nowMakingTime < fullMakingTime) {
                    nowMakingTime++;
                } else {
                    orderQueue.poll();
                    nowMakingTime = 0;
                    fullMakingTime = 0;
                }
            }

            // 마지막 손님 받고난 뒤 큐가 비어있으면 종료
            if (orderQueue.size() == 0 && nowTime > k*order.length) {
                break;
            }

            nowTime++;
        }

        return answer;
    }
}
