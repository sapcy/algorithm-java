package binarySearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2470

public class TwoWater {
    static StringBuilder sb = new StringBuilder();
    
    static int N, min;
    static int[] numbers;
    static int[] answers;
    
    public static void main(String[] args) {
        input();
        sort();
        System.out.println(sb.toString());
    }

    static void sort() {
        Arrays.sort(numbers);
        
        for (int i=0; i<N; i++) {
            int result = binarySearch(numbers, i+1, N-1, -numbers[i]);
            
            if (i < result-1) {
                if (Math.abs(numbers[result-1] + numbers[i]) < min) {
                    min = Math.abs(numbers[result-1] + numbers[i]);
                    answers[0] = numbers[i];
                    answers[1] = numbers[result-1];
                }
            } 
            
            if (result < N) {
                if (Math.abs(numbers[result] + numbers[i]) < min) {
                    min = Math.abs(numbers[result] + numbers[i]);
                    answers[0] = numbers[i];
                    answers[1] = numbers[result];
                }
            }
        }
        
        sb.append(answers[0]).append(" ").append(answers[1]);
    }

    static int binarySearch(int[] A, int L, int R, int value) {
        int result = R+1;
        
        while (L <= R) {
            int mid = (L + R)/2;

            if (numbers[mid] >= value) {
                result = mid;
                R = mid-1;
            } else if (numbers[mid] < value) {
                L = mid+1;
            }
        }
        return result;
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        min = Integer.MAX_VALUE;
        numbers = new int[N];
        answers = new int[2];
        for (int i=0; i<N; i++) {
            numbers[i] = scan.nextInt();
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