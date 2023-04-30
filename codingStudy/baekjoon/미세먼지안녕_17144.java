package codingStudy.baekjoon;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/17144

public class 미세먼지안녕_17144 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int R, C, T, answer;
    static int[] dx = { 1, 0, -1, 0};
    static int[] dy = { 0, 1, 0, -1};
    static int[] circulator;
    static int[][] board;
    static int[][] newBoard;

    static void input() {
        R = scan.nextInt();
        C = scan.nextInt();
        T = scan.nextInt();

        circulator = new int[2];
        board = new int[R][C];

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                int n = scan.nextInt();
                if (n == -1) {
                    if (circulator[0] > 1) {
                        circulator[1] = i;
                    } else {
                        circulator[0] = i;
                    }
                }
                board[i][j] = n;
            }
        }

    }

    static void spreadDust() {
        newBoard = new int[R][C];

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (board[i][j] == -1) {
                    newBoard[i][j] = board[i][j];
                    continue;
                }
                int devidedValue = board[i][j] / 5;
                int count = 0;

                for (int k=0; k<4; k++) {
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];
                    if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
                    if (board[nextX][nextY] == -1) {
                        newBoard[nextX][nextY] = -1;
                        continue;
                    }

                    newBoard[nextX][nextY] += devidedValue;
                    count++;
                }

                newBoard[i][j] += board[i][j] - devidedValue*count;
            }
        }

        board = newBoard;
    }

    static void circulateDust() {
        // 공기청정기 윗부분
        for (int i=circulator[0]-1; i>0; i--) board[i][0] = board[i-1][0];
        for (int i=0; i<C-1; i++) board[0][i] = board[0][i+1];
        for (int i=0; i<circulator[0]; i++) board[i][C-1] = board[i+1][C-1];
        for (int i=C-1; i>1; i--) board[circulator[0]][i] = board[circulator[0]][i-1];

        // 공기청정기 아랫부분
        for (int i=circulator[1]+1; i<R-1; i++) board[i][0] = board[i+1][0];
        for (int i=0; i<C-1; i++) board[R-1][i] = board[R-1][i+1];
        for (int i=R-1; i>circulator[1]; i--) board[i][C-1] = board[i-1][C-1];
        for (int i=C-1; i>1; i--) board[circulator[1]][i] = board[circulator[1]][i-1];

        board[circulator[0]][1] = 0;
        board[circulator[1]][1] = 0;
    }

    static void process() {
        while (T-- > 0) {
            spreadDust();
            circulateDust();
        }

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (board[i][j] == -1) continue;
                answer += board[i][j];
            }
        }
        sb.append(answer);
    }

    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb);
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