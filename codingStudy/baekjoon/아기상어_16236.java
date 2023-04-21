package codingStudy.baekjoon;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/16236

public class 아기상어_16236 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, fishCount, sharkSize, time;
    static Node sharkNode;
    static int[] dx = { 1, 0, -1, 0};
    static int[] dy = { 0, 1, 0, -1};
    static int[][] board;
    static boolean[][] visited;
    static Queue<Node> bfsQueue = new LinkedList<>();

    static void input() {
        N = scan.nextInt();
        sharkSize = 2;
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                int n = scan.nextInt();
                if (n == 9) {
                    sharkNode = new Node(i, j, 0);
                    board[i][j] = 0;
                } else if (n > 0){
                    board[i][j] = n;
                }
            }
        }

    }

    static void process() {

        while (true) {
            visited = new boolean[N][N];
            PriorityQueue<Node> fishes = new PriorityQueue<>();

            bfsQueue.add(sharkNode);
            visited[sharkNode.x][sharkNode.y] = true;

            while (!bfsQueue.isEmpty()) {
                Node shark = bfsQueue.poll();

                for (int i=0; i<4; i++) {
                    int nextX = shark.x + dx[i];
                    int nextY = shark.y + dy[i];
                    if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                    if (visited[nextX][nextY]) continue;

                    if (board[nextX][nextY] > 0 && board[nextX][nextY] < sharkSize) {
                        Node fish = new Node(nextX, nextY, shark.dist + 1);
                        fishes.add(fish);
                        bfsQueue.add(fish);
                        visited[nextX][nextY] = true;
                    } else if (board[nextX][nextY] == sharkSize || board[nextX][nextY] == 0) {
                        Node fish = new Node(nextX, nextY, shark.dist + 1);
                        bfsQueue.add(fish);
                        visited[nextX][nextY] = true;
                    }

                }

            }

            if (fishes.size() == 0) {
                sb.append(time);
                return;
            }

            Node eatTargetFish = fishes.poll();
            time += eatTargetFish.dist;
            fishCount++;

            if (fishCount == sharkSize) {
                sharkSize++;
                fishCount = 0;
            }
            sharkNode = new Node(eatTargetFish.x, eatTargetFish.y, 0);
            board[eatTargetFish.x][eatTargetFish.y] = 0;

        }
    }


    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb);
    }

    public static class Node implements Comparable<Node> {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            if (this.dist == n.dist && this.x != n.x) {
                return this.x - n.x;
            } else if (this.dist == n.dist && this.x == n.x) {
                return this.y - n.y;
            }
            return this.dist - n.dist;
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