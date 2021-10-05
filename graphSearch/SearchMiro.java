package graphSearch;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2178

public class SearchMiro {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] a;
    static int[][] dist;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N];
        for (int i=0; i<N; i++) {
            a[i] = scan.nextLine();
        }
        dist = new int[N][M];
    }

    // 물통 탐색 시작~
    static void bfs(int x, int y) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                dist[i][j] = -1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        dist[x][y] = 1;

        while (!queue.isEmpty()) {
            x = queue.poll();
            y = queue.poll();
            for (int k=0; k<4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (a[nx].charAt(ny) == '0') continue;
                if (dist[nx][ny] != -1) continue;

                queue.add(nx);
                queue.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() {
        bfs(0, 0);

        System.out.println(dist[N-1][M-1]);
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