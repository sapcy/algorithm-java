package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1181

public class Word {
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static String[] words;
    
    public static void main(String[] args) {
        input();
        sort();
        sb.append(words[0]).append("\n");
        for (int i=1; i<N; i++) {
            if (!words[i-1].equals(words[i])) {
                sb.append(words[i]).append("\n");
            }
            
        }
        System.out.println(sb.toString());
    }

    static void sort() {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() == b.length()) {
                    return a.compareTo(b);
                }
    
                return a.length() - b.length();
            }
        });
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        words = new String[N];
        for (int i=0; i<N; i++) { 
            words[i] = scan.nextLine();
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