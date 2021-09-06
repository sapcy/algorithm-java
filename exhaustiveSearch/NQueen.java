package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9663

public class NQueen {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    
    static int N, ans;
    static int[] selected_cols;

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        return false;
    }

    static void rec_func(int row) {
        if (row == N) {
            ans++;
        } else {
            for (int col=0; col<N; col++) {
                boolean isPossible = true;
                for (int i=0; i<row; i++) {
                    if (attackable(row, col, i, selected_cols[i])) {
                        isPossible = false;
                        break;
                    }
                }

                if (isPossible) {
                    selected_cols[row] = col;
                    rec_func(row+1);
                    selected_cols[row] = 0;
                }
            }
        }
    }

    static void input() {
        N = scan.nextInt();
        selected_cols = new int[N];
    }
    
    public static void main(String[] args) {
        input();
        rec_func(0);
        System.out.println(ans);
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