package tree;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/9489

public class Cousin {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K, k_idx;
    static int[] a, par;

    static void input() throws IOException {
        N = scan.nextInt();
        K = scan.nextInt();
        a = new int[N + 1];
        par = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = scan.nextInt();
            if (K == a[i]) {
                k_idx = i;
            }
        }
    }

    static void pro() {
        // 각 노드의 부모 노드 인덱스를 계산하자. 루트 노드가 1번 노드임을 주의하라.
        // 편의상 0번 정점의 부모를 -1 로 하자.
        par[0] = -1;
        par[1] = 0;

        // last := 이번에 자식 정점들을 찾을 노드의 인덱스
        int last = 1;
        // Hint) 사촌 := 부모의 부모는 동일하나 부모는 다른 정점의 개수
        // Hint) par 배열을 가득 채워보자.
        for (int i=1; i<=N; i++) {
            if (i==2) { par[i] = last; }
            if (i > 2) {
                if (a[i]-a[i-1]==1) {
                    par[i] = last;
                } else {
                    last += 1;
                    par[i] = last;
                }
            }
        }
        
        int count = 0;
        for (int i=1; i<=N; i++) {
            if (i == k_idx) continue;
            if (par[k_idx] == par[i]) continue;
            if (par[k_idx] <= 0 || par[i] <= 0) continue;
            if (par[par[k_idx]] == par[par[i]]) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            input();
            if (N == 0 && K == 0) break;
            pro();
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