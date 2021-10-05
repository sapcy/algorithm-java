package graphSearch;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/7562

public class ChangeName {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int L;
    static Pos start, end;
    static int ans;
    static int[][] a;
    static int[][] dir = {{2, 1}, {1, 2}, {-1, -2}, {-2, -1}, {2, -1}, {-2, 1}, {-1, 2}, {1, -2}};
    static boolean[][] visited;

    static void input() {
        L = scan.nextInt();
        start = new Pos(scan.nextInt(), scan.nextInt(), 0);
        end = new Pos(scan.nextInt(), scan.nextInt(), 0);
        a = new int[L][L];
        visited = new boolean[L][L];
    }

    static void bfs() {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();
            for (int i=0; i<8; i++) {
                int nx = curPos.x + dir[i][0];
                int ny = curPos.y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= L || ny >= L) continue;
                if (visited[nx][ny]) continue;
                if (nx == end.x && ny == end.y) {
                    ans = Math.min(ans, curPos.dist+1);
                } else {
                    queue.add(new Pos(nx, ny, curPos.dist+1));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static void pro() {
        ans = Integer.MAX_VALUE;
        bfs();

        if (ans == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
    
    static class Pos {
        int x, y, dist;

        Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
            input();
            pro();
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