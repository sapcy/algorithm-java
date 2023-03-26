package codingStudy.baekjoon.contest;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/contest/problem/970/8

public class _I_Quartet {
    static StringBuilder sb = new StringBuilder();
    
    static int N, M, max;
    static int[][] power;
    static boolean[] isSelected;
    static boolean[] isSubSelected;
    static int[] selected;
    static int[] subSelected;

    public static void main(String[] args) {
        input();
        process(0);
        System.out.println(max);
    }

    static void process(int index) {
        if (index == 4) {
            dfs(0);
        } else {
            for (int i=0; i<N; i++) {
                if (!isSelected[i]) {
                    isSelected[i] = true;
                    selected[index] = i;
                    process(index+1);
                    isSelected[i] = false;
                    selected[index] = -1;
                }
            }
        }
    }

    static void dfs(int index) {
        if (index == 4) {
            int tempPower = 0;
            for (int i=0; i<3; i++) {
                tempPower += power[subSelected[i]][subSelected[i+1]];
            }
            max = Math.max(max, tempPower);
        } else {
            for (int i=0; i<4; i++) {
                if (!isSubSelected[i]) {
                    isSubSelected[i] = true;
                    subSelected[index] = selected[i];
                    dfs(index+1);
                    isSubSelected[i] = false;
                    subSelected[index] = -1;
                }
            }
        }
    }

    static void input() {
        FastReader scan = new FastReader();
        String x = scan.nextLine();
        N = Integer.parseInt(x.split(" ")[0]);
        M = Integer.parseInt(x.split(" ")[1]);
        selected = new int[N];
        subSelected = new int[4];
        isSelected = new boolean[N];
        isSubSelected = new boolean[N];
        power = new int[N][];

        for (int i=0; i<N; i++) {
            power[i] = new int[N];
        }

        for (int i=0; i<N; i++) {
            selected[i] = -1;
        }

        for (int i=0; i<M; i++){
            String in = scan.nextLine();
            power[Integer.parseInt(in.split(" ")[0])-1][Integer.parseInt(in.split(" ")[1])-1] = Integer.parseInt(in.split(" ")[2]);
            power[Integer.parseInt(in.split(" ")[1])-1][Integer.parseInt(in.split(" ")[0])-1] = Integer.parseInt(in.split(" ")[2]);
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