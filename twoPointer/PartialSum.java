package twoPointer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1806

public class PartialSum {
    static StringBuilder sb = new StringBuilder();
    
    static int N, S;
    static int[] numbers;
    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static void process() {
        int R = -1, sum = 0, ans = N + 1;

        for (int L=0; L<N; L++) {
            // l - 1을 구간에서 제외하기
            if (L - 1 >= 0) {
                sum -= numbers[L - 1];
            }
            
            // R을 옮길 수 있을 때 까지 옮기기
            while (R + 1 < N && sum < S) {
                sum += numbers[++R];
            }

            // [L ... R]의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
            if (sum >= S) {
                ans = Math.min(ans, R-L+1);
            }
        }

        if (ans == N+1) {
            ans = 0;
        }

        System.out.println(ans);
    }
        

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        S = scan.nextInt();
        numbers = new int[N];
        for (int i=0; i<N; i++) {
            numbers[i] = scan.nextInt();
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