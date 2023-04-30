package codingStudy.baekjoon.contest.보라매컵1회예선;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/27110

public class A_특식배부 {
    static StringBuilder sb = new StringBuilder();
    
    static int N, max;
    static int[] people;
    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static void process() {
        for (int i=0; i<3; i++) {
            if (people[i] < N) max += people[i];
            else max += N;
        }

        sb.append(max);
    }
        

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        String abc = scan.nextLine();
        people = new int[3];
        people[0] = Integer.parseInt(abc.split(" ")[0]);
        people[1] = Integer.parseInt(abc.split(" ")[1]);
        people[2] = Integer.parseInt(abc.split(" ")[2]);
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