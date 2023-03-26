package codingStudy.baekjoon.contest;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/contest/problem/970/8

public class _H_인덕션 {
    static StringBuilder sb = new StringBuilder();
    
    static int N, count, max, min;
    static int[] t;
    
    public static void main(String[] args) {
        input();
        process(0);
        System.out.println(count);
    }

    static void process(int index) {
        for (int i=0; i<N; i++) {
            if (min == 0 && max == 0) {
                count += Math.min(t[i], 10-t[i]);
            } else {
                int minSum = t[i] + min;
                int maxSum = t[i] + max;
                if (minSum >= 10) minSum -= 10;
                if (maxSum >= 10) maxSum -= 10;

                if (minSum > maxSum) {

                }
            }
            count += Math.min(t[i], 10-t[i]);
//            max =
        }
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        t = new int[N];
        String[] tNum = scan.nextLine().split(" ");
        for (int i=0; i<N; i++){
            t[i] = Integer.parseInt(tNum[i]);
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