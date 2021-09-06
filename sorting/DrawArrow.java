package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15970

public class DrawArrow {
    static StringBuilder sb = new StringBuilder();
    
    static int N, sum;
    static ArrayList<Integer>[] pointList;
    
    public static void main(String[] args) {
        input();
        process();
        sb.append(sum);
        System.out.println(sb.toString());
    }

    static int arrowToLeft(int color, int idx) {
        if (idx == 0) return Integer.MAX_VALUE;
        return pointList[color].get(idx) - pointList[color].get(idx-1);
    }

    static int arrowToRight(int color, int idx) {
        if (idx == pointList[color].size() - 1) return Integer.MAX_VALUE;
        return pointList[color].get(idx+1) - pointList[color].get(idx);
    }

    static void process() {
        for (int i=1; i<=N; i++) {
            Collections.sort(pointList[i]);
        }
        
        for (int color=1; color<=N; color++) {
            for (int i=0; i<pointList[color].size(); i++) {
                int leftValue = arrowToLeft(color, i);
                int rightValue = arrowToRight(color, i);
                sum += Math.min(leftValue, rightValue);
            }
        }
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        pointList = new ArrayList[N+1];

        for (int i=1; i<=N; i++) {
            pointList[i] = new ArrayList<>();
        }
        
        for (int i=0; i<N; i++) { 
            Integer point = scan.nextInt();
            Integer color = scan.nextInt();
            
            pointList[color].add(point);
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