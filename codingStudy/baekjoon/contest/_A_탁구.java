package codingStudy.baekjoon.contest;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/contest/problem/970/1

public class _A_탁구 {
    static StringBuilder sb = new StringBuilder();
    
    static int N, X, Y;
    static String[] winners;
    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static void process() {
        for (int i=0; i<N; i++) {
            switch (winners[i]) {
                case "D": X++; break;
                case "P": Y++; break;
            }
            if (Math.abs(X-Y) >= 2) break;
        }
        sb.append(X + ":" + Y);
    }
        

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        winners = new String[N];
        for (int i=0; i<N; i++) {
            winners[i] = scan.nextLine();
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