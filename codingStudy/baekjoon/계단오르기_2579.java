package codingStudy.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class 계단오르기_2579 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] stairs, answer;

    static void input() {
        N = scan.nextInt();
        stairs = new int[N];
        answer = new int[N];
        for (int i=0; i<N; i++) {
            stairs[i] = scan.nextInt();
        }

    }

    static void process() {
        answer[0] = stairs[0];
        answer[1] = Math.max(answer[0] + stairs[1], answer[0] + stairs[2]);
        answer[2] = Math.max(answer[1] + stairs[2], answer[1] + stairs[3]);

        for (int i=3; i<N; i++) {

            answer[i] = Math.max(answer[i-1] + stairs[i], answer[i-1] + stairs[i+1]);
            System.out.println(i);
        }

        sb.append(answer[N-1]);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        process();
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