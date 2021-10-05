package twoPointer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2470

public class TwoWater {
    static StringBuilder sb = new StringBuilder();
    
    static int N, min;
    static int[] numbers;
    
    public static void main(String[] args) {
        input();
        sort();
        System.out.println(sb.toString());
    }

    static void sort() {
        Arrays.sort(numbers);

        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0, L = 0, R = N-1;
        
        while (L < R) {
            int sum = numbers[L] + numbers[R];
            if (Math.abs(sum) < best_sum) {
                best_sum = Math.abs(sum);
                v1 = numbers[L];
                v2 = numbers[R];
            }

            if (sum > 0) {
                R--;
            } else {
                L++;
            }
        }

        sb.append(v1).append(' ').append(v2);
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        min = Integer.MAX_VALUE;
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