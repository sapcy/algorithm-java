package graphSearch;

import java.io.*;
import java.util.*;

public class AttachApartNum {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, count;
    static int[][] a;
    static boolean[][] visit;
    static ArrayList<Integer> answerList;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        a = new int[N][N];
        visit = new boolean[N][N];
        answerList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            a[i] = Arrays.stream(scan.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
    }

    static void dfs(int x, int y) {
        /* TODO */
        count++;
        visit[x][y] = true;
        for (int i=0; i<4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (a[nx][ny] == 0) continue;
            if (visit[nx][ny]) continue;

            dfs(nx, ny);
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && a[i][j] == 1) {
                    // 새로운 배추흰지렁이 발견!
                    /* TODO */
                    count = 0;
                    dfs(i, j);
                    answerList.add(count);
                }
            }
        }

        Collections.sort(answerList);
        System.out.println(answerList.size());
        for (int i=0; i<answerList.size(); i++) {
            System.out.println(answerList.get(i));
        }
    }

    public static void main(String[] args) {
        input();
        pro();
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