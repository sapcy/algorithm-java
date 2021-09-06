package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11652

public class Card {
    static StringBuilder sb = new StringBuilder();
    
    static int N, cnt, maxCnt;
    static long maxNumber;
    static long[] numbers;
    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static void process() {
        Arrays.sort(numbers);
        
        maxNumber = numbers[0];
        cnt = 1;
        maxCnt = 1;

        for (int i=1; i<N; i++) {
            if (numbers[i-1] != numbers[i]) {
                cnt = 1;
            } else {
                cnt++;
            }
            
            if (cnt > maxCnt) {
                maxCnt = cnt;
                maxNumber = numbers[i];
            }
        }

        sb.append(maxNumber);
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        numbers = new long[N];

        for (int i=0; i<N; i++) { numbers[i] = scan.nextLong(); }
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