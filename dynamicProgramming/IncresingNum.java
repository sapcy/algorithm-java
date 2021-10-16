package dynamicProgramming;

import java.io.*;
import java.util.*;

public class IncresingNum {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] Dy;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        Dy = new int[N + 1][10];
    }

    static void pro() {
        // 초기값 구하기
        for (int i=0; i<10; i++) {
            Dy[1][i] = 1;
        }
        
        // 점화식을 토대로 Dy 배열 채우기
        for (int i=2; i<=N; i++) {
            Dy[i][0] = Dy[i-1][0];
            for (int j=1; j<10; j++) {
                Dy[i][j] = Dy[i][j-1] + Dy[i-1][j];
                Dy[i][j] %= 10007;
            }
        }

        // Dy배열로 정답 계산하기
        int ans = 0;
        for (int i=0; i<10; i++) {
            ans += Dy[N][i];
            ans %= 10007;
        }

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