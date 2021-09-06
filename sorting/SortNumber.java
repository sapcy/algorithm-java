package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2750

public class SortNumber {
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] numbers;
    
    public static void main(String[] args) {
        input();
        sort();
        System.out.println(sb.toString());
    }

    static void sort() {
        Arrays.sort(numbers);
        for (int i=0; i<N; i++) sb.append(numbers[i]).append("\n");
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
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