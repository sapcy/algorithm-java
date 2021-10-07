package graphSearch;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/3055

public class Escape {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] a;
    static int[][] dist_water, dist_hedgehog;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[] destPos = { -1, -1 };

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++)
            a[i] = scan.nextLine();
        visit = new boolean[N][M];
        dist_water = new int[N][M];
        dist_hedgehog = new int[N][M];
    }

    // 모든 물들을 시작으로 동시에 BFS 시작!
    static void bfs_water() {
        Queue<Integer> queue = new LinkedList<>();
        // 모든 물의 위치를 Q에 전부 넣어주기!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // dist_water 와 visit 배열 초기화
                dist_water[i][j] = -1;
                visit[i][j] = false;
                if (a[i].charAt(j) == '*') {
                    queue.add(i);
                    queue.add(j);
                    dist_water[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int i=0; i<4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (a[nx].charAt(ny) != '.') continue;

                visit[nx][ny] = true;
                dist_water[nx][ny] = dist_water[x][y] + 1;
                queue.add(nx);
                queue.add(ny);
            }
        }
    }

    // 고슴도치를 시작으로 동시에 BFS 시작!
    static boolean bfs_hedgehog() {
        Queue<Integer> queue = new LinkedList<>();
        // 고슴도치 위치를 Q에 넣어주기!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // dist_hedgehog 와 visit 배열 초기화
                dist_hedgehog[i][j] = -1;
                visit[i][j] = false;
                if (a[i].charAt(j) == 'S') {
                    queue.add(i);
                    queue.add(j);
                    dist_hedgehog[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int i=0; i<4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (a[nx].charAt(ny) != '.' && a[nx].charAt(ny) != 'D') continue;
                if (dist_water[nx][ny] != -1 && dist_water[nx][ny] <= dist_hedgehog[x][y] + 1) continue;
                

                visit[nx][ny] = true;
                dist_hedgehog[nx][ny] = dist_hedgehog[x][y] + 1;
                if (a[nx].charAt(ny) == 'D') {
                    queue.clear();
                    // check = true;
                    destPos[0] = nx;
                    destPos[1] = ny;
                    return true;
                }
                queue.add(nx);
                queue.add(ny);
            }
        }

        return false;
    }

    static void pro() {
        // 각 칸마다 물에 닿는 시간 계산하기
        bfs_water();
        // 고슴도치가 물을 피해 탐색할 수 있는 공간 찾기
        if (bfs_hedgehog()) {
            System.out.println(dist_hedgehog[destPos[0]][destPos[1]]);
        } else {
            System.out.println("KAKTUS");
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