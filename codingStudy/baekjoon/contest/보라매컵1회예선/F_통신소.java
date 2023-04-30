package codingStudy.baekjoon.contest.보라매컵1회예선;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/27115

public class F_통신소 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();
    
    static int N, M, K, answer;
    static boolean[][] visited;
    static PriorityQueue<Tonsinso> priQue = new PriorityQueue<>();
    static Queue<Tonsinso> queue = new LinkedList<>();

    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static void process() {
        bfs();
        for (int i=1; i<N+1; i++) {
            for (int j=1; j<M+1; j++) {
                if (visited[i][j]) answer++;
            }
        }
        sb.append(answer);
    }

    static int calLength(int originX, int originY, int targetX, int targetY) {
        return Math.abs(originX - targetX) + Math.abs(originY - targetY);
    }

    static void bfs() {
        while (!priQue.isEmpty()) {
            Tonsinso t = priQue.poll();

            visited[t.x][t.y] = true;
            queue.add(new Tonsinso(t.x+1, t.y, 0));
            queue.add(new Tonsinso(t.x, t.y+1, 0));
            queue.add(new Tonsinso(t.x-1, t.y, 0));
            queue.add(new Tonsinso(t.x, t.y-1, 0));

            while (!queue.isEmpty()) {
                Tonsinso t2 = queue.poll();
                if (t2.x <= 0 || t2.x >= N+1 || t2.y <= 0 || t2.y >= M+1) continue;

                int length = calLength(t.x, t.y, t2.x, t2.y);
                if (!visited[t2.x][t2.y] && length <= t.power) {
                    visited[t2.x][t2.y] = true;

                    if (length < t.power) {
                        queue.add(new Tonsinso(t2.x+1, t2.y, 0));
                        queue.add(new Tonsinso(t2.x, t2.y+1, 0));
                        queue.add(new Tonsinso(t2.x-1, t2.y, 0));
                        queue.add(new Tonsinso(t2.x, t2.y-1, 0));
                    }
                }
            }
        }

    }
        

    static void input() {
        String next = scan.nextLine();
        N = Integer.parseInt(next.split(" ")[0]);
        M = Integer.parseInt(next.split(" ")[1]);
        K = Integer.parseInt(next.split(" ")[2]);
        visited = new boolean[N+1][M+1];

        for (int i=0; i<K; i++) {
            String next2 = scan.nextLine();
            Tonsinso t = new Tonsinso(Integer.parseInt(next2.split(" ")[0]),
                    Integer.parseInt(next2.split(" ")[1]),
                    Integer.parseInt(next2.split(" ")[2]));

            priQue.add(t);
        }
    }

    static class Tonsinso implements Comparable<Tonsinso> {
        public int x;
        public int y;
        public int power;

        public Tonsinso(int x, int y, int power) {
            this.x = x;
            this.y = y;
            this.power = power;
        }

        @Override
        public int compareTo(Tonsinso t) {
            return this.power - t.power;
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