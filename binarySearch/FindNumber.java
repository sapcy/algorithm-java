package binarySearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1920

public class FindNumber {
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static int[] numbers;
    static int[] integers;
    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static void process() {
        Arrays.sort(numbers);
        
        for (int i=0; i<M; i++) {
            sb.append(binarySearch(0, N-1, integers[i])).append('\n');
        }
    }
        
    static int binarySearch(int L, int R, int value) {
        while (L <= R) {
            int mid = (L + R) / 2;
            if (numbers[mid] == value) {
                return 1;
            }

            if (numbers[mid] >= value) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return 0;
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        numbers = new int[N];
        for (int i=0; i<N; i++) {
            numbers[i] = scan.nextInt();
        }

        M = scan.nextInt();
        integers = new int[M];
        for (int i=0; i<M; i++) {
            integers[i] = scan.nextInt();
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