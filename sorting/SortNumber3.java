package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10989

public class SortNumber3 {
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] numbers;
    
    public static void main(String[] args) {
        input();
        sort();
        System.out.println(sb.toString());
    }

    static void sort() {
        for (int i=0; i<10001; i++) { 
            if (numbers[i] > 0) {
                for (int j=0; j<numbers[i]; j++) {
                    sb.append(i).append("\n");
                }
            }
        }
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        numbers = new int[10001];
        for (int i=0; i<N; i++) {
            numbers[scan.nextInt()] += 1;
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