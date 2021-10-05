package graphSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1260

public class DFSnBFS {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
    }

    // x 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x) {
        /* TODO */
        visit[x] = true;
        for (int y=0; y<N; y++) {
            if (adj[x][y] == 1) continue;
            if (visit[y]) continue;
            dfs(y);
        }
    }

    // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        /* TODO */
        que.add(start);
        visit[start] = true;

        while (!que.isEmpty()) {
            start = que.poll();
            sb.append(start).append(' ');
            for (int y=0; y<N; y++) {
                if (adj[start][y] == 0) continue;
                if (visit[y]) continue;
                que.add(y);
            }
        }
    }

    static void pro() {
        // 모든 x에 대해서 adj[x] 정렬하기
        /* TODO */
        visit = new boolean[N];
        dfs(V);
        sb.append('\n');
        for (int i=0; i<N; i++) {
            visit[i] = false;
        }
        bfs(V);
        // DFS, BFS 결과 구하기
        /* TODO */

        System.out.println(sb);
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