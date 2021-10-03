package graphSearch;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class ChangeName {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int L;
    static Pos start, end;
    static int min, ans;
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
        /* TODO */
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
            }
        }
    }

    static int distance(int x, int y, int destX, int destY) {
        return (int) Math.sqrt(Math.pow(Math.abs(destX - x), 2) + Math.pow(Math.abs(destY - y), 2));
    }

    static void pro() {
        ans = 0;
        bfs(curX, curY);

        System.out.println(ans);
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