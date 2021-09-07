package binarySearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7795

public class EatOrGetEaten {
    static StringBuilder sb = new StringBuilder();
    
    static int N, A, B;
    static int[][][] numbers;
    static int[] answers;
    
    public static void main(String[] args) {
        input();
        sort();
        System.out.println(sb.toString());
    }

    static void sort() {
        for (int i=0; i<N; i++) {
            Arrays.sort(numbers[i][1]);
        }
        
        for (int index=0; index<N; index++) {
            for (int i=0; i<numbers[index][0].length; i++) {
                answers[index] += binarySearch(numbers[index][1], numbers[index][0][i]);
            }
        }

        for (int i=0; i<N; i++) {
            sb.append(answers[i]).append('\n');
        }
    }

    static int binarySearch(int[] arr, int value) {
        int result = 0;
        int left = 0;
        int right = arr.length-1;

        if (arr[left] >= value) {
            return left;
        }
        else if (arr[right] < value) {
            return arr.length;
        }

        while (left <= right) {
            int mid = (left + right)/2;

            if (arr[mid] < value) {
                result = mid+1;
                left = mid+1;
            } else if (arr[mid] >= value) {
                right = mid-1;
            }
        }
        return result;
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        answers = new int[N];
        numbers = new int[N][2][];
        for (int i=0; i<N; i++) { 
            A = scan.nextInt();
            B = scan.nextInt();
            numbers[i][0] = new int[A];
            numbers[i][1] = new int[B];
            for (int j=0; j<A; j++) {
                numbers[i][0][j] = scan.nextInt();
            }
            for (int j=0; j<B; j++) {
                numbers[i][1][j] = scan.nextInt();
            }
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