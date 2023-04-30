package codingStudy.baekjoon.contest;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/27920

public class _C_카드뒤집기 {
    static StringBuilder sb = new StringBuilder();

    static int N;
//    static String cards;
    static char[] card;

    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static void process() {
        if (N == 0) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
        for (int i=1; i<N; i++) {
//            String cur = String.valueOf(i+1);
            int value = i+1;
            card[N/2 + i-1] = (char)(value + '0');
        }

//        System.out.print(sb);
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
//        cards = new String[N];
        card = new char[N];

        // 1번째
//        card[0] = 1;
//        sb.append(1);
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