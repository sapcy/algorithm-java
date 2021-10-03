package twoPointer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15565

public class CuteRyan {
    static StringBuilder sb = new StringBuilder();
    
    static int N, K;
    static int[] dolls;
    static ArrayList<Integer> ryans;
    
    public static void main(String[] args) {
        input();
        process();
    }

    static void process() {
        int right = -1, ans = -1, sum = 0;
        for (int left = 0; left < N; left++) {
            while (sum < K && right+1 < N) {
                if (dolls[++right] == 1) {
                    sum += 1;
                }
            }

            if (sum == K) {
                if (ans == -1) {
                    ans = right - left + 1;
                } else {
                    ans = Math.min(ans, right - left + 1);
                }
            }

            if (dolls[left] == 1) {
                sum -= 1;
            }
        }

        System.out.println(ans);
    }
    
    // 0 4 6 9
    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        K = scan.nextInt();
        dolls = new int[N];
        ryans = new ArrayList<>();
        for (int i=0; i<N; i++) {
            dolls[i] = scan.nextInt();
            if (dolls[i] == 1) {
                ryans.add(i);
            }
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