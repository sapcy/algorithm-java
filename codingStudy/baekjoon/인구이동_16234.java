package codingStudy.baekjoon;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/16234

public class 인구이동_16234 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, L, R, count;
    static int[] dx = { 1, 0, -1, 0};
    static int[] dy = { 0, 1, 0, -1};
    static int[][] board;
    static boolean[][] visited;
    static Queue<Nation> bfsQueue = new LinkedList<>();
    static Queue<Nation> targetNations = new LinkedList<>();

    static void input() {
        N = scan.nextInt();
        L = scan.nextInt();
        R = scan.nextInt();
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                board[i][j] = scan.nextInt();
            }
        }

    }

    static void process() {

        while (true) {
            boolean isMoved = false;
            visited = new boolean[N][N];

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (visited[i][j]) continue;

                    int sectionTotal = search(i, j);
                    if (!targetNations.isEmpty()) {
                        int avg = sectionTotal / targetNations.size();
                        while (!targetNations.isEmpty()) {
                            Nation nation = targetNations.poll();
                            board[nation.x][nation.y] = avg;
                        }
                        isMoved = true;
                    }
                }
            }

            // 한번도 이동이 없었으면 끝
            if (!isMoved) break;

            count++;
        }

        sb.append(count);
    }

    static int search(int x, int y) {
        int sectionTotal = 0;
        bfsQueue.add(new Nation(x, y));
        targetNations.add(new Nation(x, y));
        sectionTotal += board[x][y];
        visited[x][y] = true;

        while (!bfsQueue.isEmpty()) {
            Nation target = bfsQueue.poll();

            for (int i=0; i<4; i++) {
                int nextX = target.x + dx[i];
                int nextY = target.y + dy[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if (visited[nextX][nextY]) continue;

                // 합치는 대상 노드 선별
                int valueDiff = Math.abs(board[target.x][target.y] - board[nextX][nextY]);
                if (valueDiff >= L && valueDiff <= R) {
                    Nation nextNation = new Nation(nextX, nextY);
                    bfsQueue.add(nextNation);
                    targetNations.add(nextNation);
                    visited[nextX][nextY] = true;
                    sectionTotal += board[nextX][nextY];
                }
            }

        }

        // 아무 노드도 추가되지 않았으면 합칠 대상 없으므로 큐 비우기
        if (targetNations.size() == 1) {
            targetNations.poll();
        }

        return sectionTotal;
    }

    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb);
    }

    public static class Nation {
        int x;
        int y;

        public Nation(int x, int y) {
            this.x = x;
            this.y = y;
        }
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