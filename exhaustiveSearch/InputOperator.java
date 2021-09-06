package exhaustiveSearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14888

public class InputOperator {
    static StringBuilder sb = new StringBuilder();
    
    static int N, max, min;
    static int[] nums, operators, order;
    
    public static void main(String[] args) {
        input();
        rec_func(0, nums[0]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }

    static int calculator(int operand1, int operator, int operand2) {
        if (operator == 0) return operand1 + operand2;
        else if (operator == 1) return operand1 - operand2;
        else if (operator == 2) return operand1 * operand2;
        else return operand1 / operand2;
    }

    static void rec_func(int index, int value) {
        if (index == N-1) {
            // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int i=0; i<4; i++) {
                if (operators[i] >= 1) {
                    operators[i]--;
                    rec_func(index+1, calculator(value, i, nums[index+1]));
                    operators[i]++;
                }
            }
        }
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        nums = new int[N];
        operators = new int[4];
        for (int i=0; i<N; i++) nums[i] = scan.nextInt();
        for (int i=0; i<4; i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
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

    // if (k == M + 1) {
    //     for (int i=1; i<M; i++) sb.append(selected[i]).append(' ');
    //     sb.append('\n');
    // } else {
    //     for (int i=1; i<=N; i++) {
    //         selected[k] = i;
    //         rec_func(k+1);
    //         selected[k] = 0;
    //     }
    // }
    
    
}