package dynamicProgramming;

import java.io.*;
import java.util.*;

public class Tiling2xn {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] Dy;

    static void preprocess() {
        Dy = new int[1001];
        // 초기값 구하기
        Dy[1] = 1;
        Dy[2] = 2;

        N = scan.nextInt();

        // 점화식을 토대로 Dy 배열 채우기
        for (int i=3; i<=N; i++) {
            Dy[i] = Dy[i-1] + Dy[i-2];
        }
    }

    static void pro() {
        sb.append(Dy[N] % 10007);
        System.out.print(sb);
    }

    public static void main(String[] args) {
        preprocess();
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