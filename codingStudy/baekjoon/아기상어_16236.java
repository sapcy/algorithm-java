package codingStudy.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16236

public class 아기상어_16236 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, dist, sharkSize, sharkX, sharkY;
    static int[] dx = { 1, 0, -1, 0};
    static int[] dy = { 0, 1, 0, -1};
    static int[][] board;
    static boolean[][] visited;
    static Queue<Node> bfsQueue = new LinkedList<>();
    static Queue<Node> targetNodes = new LinkedList<>();

    static void input() {
        N = scan.nextInt();
        sharkSize = 2;
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                board[i][j] = scan.nextInt();
                if (board[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }

    }

    static void process() {

        while (true) {
            boolean isMoved = false;
            visited = new boolean[N][N];

            search(sharkX, sharkY);


            // 한번도 이동이 없었으면 끝
            if (!isMoved) break;

            count++;
        }

        sb.append(count);
    }

    static int search(int x, int y) {
        int dist = 0;
        bfsQueue.add(new Node(x, y, 0));
        visited[x][y] = true;

        while (!bfsQueue.isEmpty()) {
            Node target = bfsQueue.poll();

            for (int i=0; i<4; i++) {
                int nextX = target.x + dx[i];
                int nextY = target.y + dy[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if (visited[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                bfsQueue.add(new Node(nextX, nextY, ))

            }

        }

        // 아무 노드도 추가되지 않았으면 합칠 대상 없으므로 큐 비우기
        if (targetNodes.size() == 1) {
            targetNodes.poll();
        }

        return sectionTotal;
    }

    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb);
    }

    public static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
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