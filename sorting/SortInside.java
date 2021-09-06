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

// https://www.acmicpc.net/problem/1427

public class SortInside {
    static StringBuilder sb = new StringBuilder();
    static String[] numbers;
    
    public static void main(String[] args) {
        input();
        sort();
        System.out.println(sb.toString());
    }

    static void sort() {
        Arrays.sort(numbers, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.parseInt(s2) - Integer.parseInt(s1);
            }
        });

        for (int i=0; i<numbers.length; i++) sb.append(numbers[i]);
    }

    static void input() {
        FastReader scan = new FastReader();
        numbers = scan.nextLine().split("");
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