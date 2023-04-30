package codingStudy.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3190

public class 퇴사_14501 {

    static int N;
    static int answer = Integer.MIN_VALUE;

    static int[] processTimeList;
    static int[] moneyList;

    public static void main(String[] args) {
        input();
        process(0, 0);
        System.out.println(answer);
    }

    static void process(int start, int sum) {
        if (start >= N) {
            answer = Math.max(sum, answer);
        } else {
            if (start + processTimeList[start] <= N) {
                process(start + processTimeList[start], sum + moneyList[start]);
            }
            process(start + 1, sum);
        }
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        processTimeList = new int[N];
        moneyList = new int[N];

        for (int i=0; i<N; i++) {
            String[] next = scan.nextLine().split(" ");
            processTimeList[i] = Integer.parseInt(next[0]);
            moneyList[i] = Integer.parseInt(next[1]);
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