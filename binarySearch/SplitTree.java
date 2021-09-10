package binarySearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2805
// 원래 문제 : 원하는 길이 M 만큼을 얻을 수 있는 최대 높이(H)는 얼마인가?
// 뒤집은 문제 : 어떤 높이(H)로 잘랐을 때, 원하는 길이 M 만큼을 얻을 수 있는가? Yes/No
// 매개변수 : 높이(H)
// 17: No, 2: Yes
// <핵심>
// 1. 정답을 "매개 변수(Parameter)"로 만들고 Yes/No 문제(결정 문제)로 바꿔 보기
// 2. 모든 값에 대해서 Yes/No를 채웠다고 생각했을 때, 정렬된 상태인가?
// 3. Yes/No 결정하는 문제를 풀기!

public class SplitTree {
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static int[] trees;
    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static boolean determination(int H) {
        // H 높이로 나무들을 잘랐을 때, M 만큼을 얻을 수 있으면 true, 없으면 false를 return
        long sum=0;
        for (int i=0; i<N; i++) {
            if (trees[i] > H) {
                sum += trees[i] - H;
            }
        }

        return sum >= M;
    }

    static void process() {
        Arrays.sort(trees);
        long L=0, R=2000000000, ans=0;

        while (L <= R) {
            long mid = (L + R) / 2;
            if (determination((int)mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        sb.append(ans);
    }
        

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        trees = new int[N];
        for (int i=0; i<N; i++) {
            trees[i] = scan.nextInt();
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