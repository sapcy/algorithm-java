package codingStudy.baekjoon;

import java.io.*;
import java.util.*;

public class 인구이동_16234 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, L, R, count, total;
    static int[][] board;
    static boolean[][] visited;
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

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    search(i, j);
                    if (!targetNations.isEmpty()) {
                        int avg = total / targetNations.size();
                        while (!targetNations.isEmpty()) {
                            Nation nation = targetNations.poll();
                            board[nation.x][nation.y] = avg;
                        }
                    } else {
                        break;
                    }
                }
            }



            count++;
        }

        System.out.println(count);
    }

    static void search(int i, int j) {
        total = 0;
        visited = new boolean[N][N];

        while ()
    }

    static void compare(int x, int y, int compareX, int compareY) {
        int value = Math.abs(board[x][y] - board[compareX][compareY]);
        if (value >= L && value <= R) {
            if (!visited[x][y]) {
                targetNations.add(new Nation(x, y));
                visited[x][y] = true;
                total += board[x][y];
            }

            if (!visited[compareX][compareY]) {
                targetNations.add(new Nation(compareX, compareY));
                visited[compareX][compareY] = true;
                total += board[compareX][compareY];
            }
        }
    }

    public static void main(String[] args) {
        input();
        process();
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