package twoPointer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3273

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    static int N, X;
    static int[] numbers;
    
    public static void main(String[] args) {
        input();
        process();
    }

    static void process() {
        Arrays.sort(numbers);
        int L = 0, R = N-1, sum = 0, ans = N;

        while (L < R) {
            sum = numbers[L] + numbers[R];

            if (sum == X) {
                if (ans == N) {
                    ans = 1;
                } else {
                    ans++;
                }
            }

            if (sum > X) {
                R--;
            } else {
                L++;
            }
        }
        
        
        // ans 값을 보고 불가능 판단하기
        if (ans == N) {
            ans = 0;
        }
        System.out.println(ans);
    }
    
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        numbers = new int[N];
        for (int i=0; i<N; i++) {
            numbers[i] = scan.nextInt();
        }
        X = scan.nextInt();

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