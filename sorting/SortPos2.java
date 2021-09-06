package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11651

public class SortPos2 {
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static Pos[] poses;
    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static class Pos implements Comparable<Pos> {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pos p) {
            if (p.y == this.y) {
                return this.x - p.x;
            } 
            return this.y - p.y;
        }
    } 

    static void process() {
        Arrays.sort(poses);
        for (int i=0; i<N; i++) sb.append(poses[i].x + " " + poses[i].y).append("\n");
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        poses = new Pos[N];
        for (int i=0; i<N; i++) { 
            poses[i] = new Pos(scan.nextInt(), scan.nextInt());
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