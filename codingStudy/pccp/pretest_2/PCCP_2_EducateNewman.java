package codingStudy.pccp.pretest_2;

import java.util.Arrays;

class PCCP_2_EducateNewman {
    public static void main(String[] args) {
        int[] abilities = {10, 3, 7, 2};
        int number = 2;

        System.out.println(solution(abilities, number));
    }

    public static int solution(int[] ability, int number) {
        int answer = 0;

        Arrays.sort(ability);

        for (int i=0; i<number; i++) {
            if (ability[1] > ability[2]) {
                Arrays.sort(ability);
            }

            int value = ability[0] + ability[1];
            ability[0] = value;
            ability[1] = value;
        }

        for (int i=0; i<ability.length; i++) {
            answer += ability[i];
        }

        return answer;
    }
}