package codingStudy.baekjoon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자_끼워넣기_14888 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, maxValue, minValue;
    static int[] operators, numbers;

    static int calc(int op1, int operator, int op2) {
        if (operator == 0) return op1 + op2;
        else if (operator == 1) return op1 - op2;
        else if (operator == 2) return op1 * op2;
        else if (operator == 3) return op1 / op2;
        return 0;
    }

    static void rec_func(int index, int value) {
        if (index == N-1) {
            maxValue = Math.max(maxValue, value);
            minValue = Math.min(minValue, value);
        } else {
            for (int i=0; i<4; i++) {
                if (operators[i] > 0) {
                    operators[i]--;
                    rec_func(index+1, calc(value, i, numbers[index+1]));
                    operators[i]++;
                }
            }
        }
    }

    static void input() {
        N = scan.nextInt();

        operators = new int[4];
        numbers = new int[N];

        for (int i=0; i<N; i++) {
            numbers[i] = scan.nextInt();
        }

        for (int i=0; i<4; i++) {
            operators[i] = scan.nextInt();
        }

        maxValue = Integer.MIN_VALUE;
        minValue = Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        input();
        rec_func(0, numbers[0]);
        sb.append(maxValue).append("\n").append(minValue);
        System.out.println(sb.toString());
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