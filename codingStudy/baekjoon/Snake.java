package codingStudy.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3190

public class Snake {
    static StringBuilder sb = new StringBuilder();
    
    static int N, K, L;
    static int direction = 0;
    static int directionIndex = 0;
    static int time = 0;
    static int[] snakeHead;
    static boolean[][] apple;
    static boolean[][] board;
    static List<int[]> snake = new ArrayList<>();
    static int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0,-1}};
    static String[] directionInfo;
    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static void process() {
        while (true) {
            String[] info = directionInfo[directionIndex].split(" ");
            int changeTime = Integer.parseInt(info[0]);

            // 방향전환 시간 갱신
            if (changeTime < time && directionIndex < directionInfo.length) {
                info = directionInfo[++directionIndex].split(" ");
                changeTime = Integer.parseInt(info[0]);

            }

            // 전진
            snakeHead[0] += directions[Math.abs(direction)%4][0];
            snakeHead[1] += directions[Math.abs(direction)%4][1];
            board[snakeHead[0]][snakeHead[1]] = true;
            snake.add(new int[]{snakeHead[0], snakeHead[1]});

            // 벽에 박았는지, 몸에 닿았는지 체크
            if (snakeHead[0] >= N || snakeHead[1] >= N) break;
            if (board[snakeHead[0]][snakeHead[1]]) break;

            // 사과 있으면 먹기
            if (apple[snakeHead[0]][snakeHead[1]]) {
                apple[snakeHead[0]][snakeHead[1]] = false;
            }
            else {
                board[snake.get(0)[0]][snake.get(0)[1]] = false;
                snake.remove(0);
            }

            // 방향 전환
            if (changeTime == time) {
                if (info[0].equals("L")) {
                    direction--;
                } else {
                    direction++;
                }
            }

            time++;
        }

        sb.append(time);
    }
        

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        apple = new boolean[N][N];
        board = new boolean[N][N];

        // 사과의 위치 횟수
        K = scan.nextInt();
        for (int i=0; i<K; i++) {
            String[] pos = scan.nextLine().split(" ");
            int x = Integer.parseInt(pos[0]);
            int y = Integer.parseInt(pos[1]);
            apple[x][y] = true;
        }

        // 뱀의 방향 변환 횟수
        L = scan.nextInt();
        directionInfo = new String[L];
        for (int i=0; i<L; i++) {
            directionInfo[i] = scan.nextLine();
        }

        // 뱀 위치 세팅
        board[0][0] = true;
        snake.add(new int[]{0, 0});
        snakeHead = new int[]{0, 0};
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}