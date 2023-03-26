package codingStudy.baekjoon.contest;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/contest/problem/970/7

public class _E_현대모비스입사프로젝트 {
    static StringBuilder sb = new StringBuilder();
    
    static int N, K, max;
    static int[][] scores;
    static int[] selected;
    static boolean[] isExist;
    
    public static void main(String[] args) {
        input();
        process(0);
        System.out.println(max);
    }

    static void process(int index) {
        if (index == K) {
            int[] tempArr = new int[N];
            for (int i=0; i<selected.length; i++) {
                if (selected[i] < 0) return;
                for (int j=0; j<3; j++) {
                    tempArr[j] += scores[selected[i]][j];
                }
            }
            Arrays.sort(tempArr);
            max = Math.max(max, tempArr[N-1] + tempArr[N-2]);
        } else {
            for (int i=0; i<N; i++) {
                if (!isExist[index]) {
                    selected[index] = i;
                    isExist[i] = true;
                    process(index+1);
                    isExist[i] = false;
                    selected[index] = -1;
                }
            }
        }
    }

    static void input() {
        FastReader scan = new FastReader();
        String NK = scan.nextLine();
        N = Integer.parseInt(NK.split(" ")[0]);
        K = Integer.parseInt(NK.split(" ")[1]);
        scores = new int[N][];
        for (int i=0; i<N; i++) {
            String next = scan.nextLine();
            scores[i] = new int[3];
            for (int j=0; j<3; j++) {
                scores[i][j] = Integer.parseInt(next.split(" ")[j]);
            }
        }

        isExist = new boolean[N];
        selected = new int[K];
        for (int i=0; i<K; i++) {
            selected[i] = -1;
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