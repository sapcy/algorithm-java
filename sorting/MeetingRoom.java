package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1931

public class MeetingRoom {
    static StringBuilder sb = new StringBuilder();
    
    static int N, prevEnd, count;
    static Time[] times;
    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(count);
    }

    static class Time implements Comparable<Time> {
        int start, end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time p) {
            if (this.end == p.end) {
                return this.start - p.start;
            }
            return this.end - p.end;
        }
    } 

    static void process() {
        Arrays.sort(times);
        
        for (int i=0; i<N; i++) {
            if (prevEnd <= times[i].start) {
                prevEnd = times[i].end;
                count++;
            }
        }
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        times = new Time[N];

        for (int i=0; i<N; i++) { 
            times[i] = new Time(scan.nextInt(), scan.nextInt());
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