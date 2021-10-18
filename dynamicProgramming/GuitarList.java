package dynamicProgramming;

import java.io.*;
import java.util.*;

public class GuitarList {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S, M;
    static int[] A;
    static int[][] Dy;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        Dy = new int[N + 1][2];
        
        for (int i=1; i<=N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void pro() {
        // 초기값 구하기
        Dy[1][0] = A[1];
        Dy[1][1] = A[1];

        // 점화식을 토대로 Dy 배열 채우기
        /* TODO */

        // Dy배열로 정답 계산하기
        int ans = 0;
        /* TODO */

        System.out.println(ans);
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
