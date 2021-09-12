package binarySearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2512

public class Budget {
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static int[] budgets;
    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static boolean determination(int budget) {
        int sum=0;
        for (int i=0; i<N; i++) {
           sum += Math.min(budget, budgets[i]);
        }

        return sum <= M;
    }

    static void process() {
        Arrays.sort(budgets);
        int L=1, R=budgets[budgets.length-1], ans=0;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        sb.append(ans);
    }
        

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        budgets = new int[N];
        for (int i=0; i<N; i++) {
            budgets[i] = scan.nextInt();
        }
        M = scan.nextInt();
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