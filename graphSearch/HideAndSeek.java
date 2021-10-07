package graphSearch;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1697

public class HideAndSeek {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static String[] a;
    static boolean[] visit;
    static int[] dist;
    static int[] dir = { -1, 1, 2};

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        dist = new int[100005];
        visit = new boolean[100005];
    }
    
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        dist[N] = 0;
        visit[N] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int i=0; i<3; i++) {
                int y=x;
                if (i != 2) y += dir[i];
                else y *= dir[i];

                if (y >= 0 && y <= 100000 && !visit[y]) {
                    queue.add(y);
                    visit[y] = true;
                    dist[y] = dist[x]+1;

                    if (y == K) {
                        queue.clear();
                        return;
                    }
                }
            }
            
        }
    }

    static void pro() {
        bfs();
        System.out.println(dist[K]);
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