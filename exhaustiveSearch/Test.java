package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1182

public class Test {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N, S, answer;
    static int[] numbers;

    static void rec_func(int index, int value) {
        if (index == N) {
            if (S == value) {
                answer++;
            }
        } else {
            for (int i=0; i<N; i++) {
                rec_func(index+1, value+numbers[i]);
                rec_func(index+1, value);
            }
        }
    }

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        numbers = new int[N];

        for (int i=0; i<N; i++) numbers[i] = scan.nextInt();
    }
    
    public static void main(String[] args) {
        input();
        rec_func(0, 0);

        if (S == 0) {
            answer = 1;
        }

        System.out.println(answer);
        // System.out.println(sb.toString());
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