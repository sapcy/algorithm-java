package codingStudy.pccp.pretest_2;

class PCCP_1_Robot {
    public static void main(String[] args) {
        String command = "GRGLGRG";

        System.out.println(solution(command));
    }

    public static int[] solution(String command) {
        int[] pos = {0,0};
        int[] values = {0,1};
        char[] charCommands = command.toCharArray();

        for (int i=0; i<charCommands.length; i++) {
            switch (charCommands[i]) {
                case 'R': {
                    if (values[0] == 1 && values[1] == 0) {
                        values[0] = 0;
                        values[1] = -1;
                    } else if (values[0] == -1 && values[1] == 0) {
                        values[0] = 0;
                        values[1] = 1;
                    } else {
                        int tmp = values[0];
                        values[0] = values[1];
                        values[1] = tmp;
                    }
                    break;
                }
                case 'L': {
                    if (values[0] == 0 && values[1] == 1) {
                        values[0] = -1;
                        values[1] = 0;
                    } else if (values[0] == 0 && values[1] == -1) {
                        values[0] = 1;
                        values[1] = 0;
                    } else {
                        int tmp = values[0];
                        values[0] = values[1];
                        values[1] = tmp;
                    }
                    break;
                }
                case 'G': {
                    pos[0] += values[0];
                    pos[1] += values[1];
                    break;
                }
                case 'B': {
                    pos[0] -= values[0];
                    pos[1] -= values[1];
                    break;
                }
            }
        }

        return pos;
    }
}
