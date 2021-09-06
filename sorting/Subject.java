package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10825

public class Subject {
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static People[] pArr;
    
    public static void main(String[] args) {
        input();
        sort();
        for (int i=0; i<N; i++) {
            sb.append(pArr[i].name).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void sort() {
        Arrays.sort(pArr);
    }

    static class People implements Comparable<People> {
        Integer korean;
        Integer english;
        Integer math;
        String name;

        public People(String name, Integer korean, Integer english, Integer math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(People p) {
            if (p.korean != this.korean) {
                return p.korean - this.korean;
            } else if (p.english != this.english) {
                return this.english - p.english;
            } else if (p.math != this.math) {
                return p.math - this.math;
            } else {
                return this.name.compareTo(p.name);
            }
        }
    } 

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        pArr = new People[N];
        for (int i=0; i<N; i++) { 
            String s = scan.nextLine();
            pArr[i] = new People(s.split(" ")[0], Integer.parseInt(s.split(" ")[1]), Integer.parseInt(s.split(" ")[2]), Integer.parseInt(s.split(" ")[3])); 
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