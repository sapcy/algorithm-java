package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1015

public class SortNumberArray {
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] P;
    static Elem[] B;
    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static class Elem implements Comparable<Elem> {
        int num, idx;

        public Elem(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Elem e) {
            if (e.num != this.num) {
                return this.num - e.num;
            }

            return this.idx - e.idx;
        }
    }

    static void process() {
        Arrays.sort(B);

        for (int i=0; i<N; i++) {
            P[B[i].idx] = i;
        }

        for (int i=0; i<N; i++) {
            sb.append(P[i]).append(" ");
        }
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        P = new int[N];
        B = new Elem[N];

        for (int i=0; i<N; i++) {
            B[i] = new Elem(scan.nextInt(), i);
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