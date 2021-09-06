import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15649

public class NandM2 {
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static int[] selected, used;
    
    public static void main(String[] args) {
        input();
        rec_func(0);
        System.out.println(sb.toString());
    }

    static void rec_func(int index) {
        if (index == M) {
            for (int i=0; i<M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int i=1; i<=N; i++) {
                if (used[i] != 1) {
                    selected[index] = i;
                    used[i] = 1;
                    rec_func(index+1);
                    selected[index] = 0;
                    used[i] = 0;
                }
            }
        }
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
        used = new int[N + 1];
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

    // if (k == M + 1) {
    //     for (int i=1; i<M; i++) sb.append(selected[i]).append(' ');
    //     sb.append('\n');
    // } else {
    //     for (int i=1; i<=N; i++) {
    //         selected[k] = i;
    //         rec_func(k+1);
    //         selected[k] = 0;
    //     }
    // }
    
    
}