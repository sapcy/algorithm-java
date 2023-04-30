package codingStudy.baekjoon.contest.보라매컵1회예선;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/27111

public class B_출입기록 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();
    
    static int N, count;
    static Map<Integer, Integer> report = new HashMap<>();

    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static void process() {
        for (int i=0; i<N; i++) {
            String rep = scan.nextLine();
            int number = Integer.parseInt(rep.split(" ")[0]);
            int input = Integer.parseInt(rep.split(" ")[1]);
            if (!report.containsKey(number)) {
                if (input == 0) {
                    count++;
                } else {
                    report.put(number, input);
                }
            } else {
                if (report.get(number) == 0) {
                    if (input == 1) report.put(number, input);
                    else count++;
                } else {
                    if (input == 0) report.put(number, input);
                    else count++;
                }
            }
        }

        for (int i : report.keySet()) {
            if (report.get(i) == 1) {
                count++;
            }
        }

        sb.append(count);
    }
        

    static void input() {
//        FastReader scan = new FastReader();
        N = scan.nextInt();
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