package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

class GanhoAlba {
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static long sum;
    static Integer[] tips;
    
    public static void main(String[] args) {
        input();
        sort();
        pro();
        System.out.println(sb.toString());
    }

    static void pro() {
        for (int i=1; i<=N; i++) {
            int result = tips[i-1] - (i-1);
            if (result < 0) break;
            sum += (long)result;
        }
        sb.append(sum);
    }

    static void sort() {
        Arrays.sort(tips, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        tips = new Integer[N];
        for (int i=0; i<N; i++) {
            tips[i] = scan.nextInt();
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