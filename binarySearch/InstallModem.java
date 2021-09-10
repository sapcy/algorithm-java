package binarySearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2110
// 원래 문제: C개의 공유기를 설치했을 때, 최대 인접 거리(D)는 얼마인가?
// 뒤집은 문제: 어떤 거리(D) 만큼의 거리를 둘 때, 공유기 C개를 설치할 수 있는가? Yes/No

public class InstallModem {
    static StringBuilder sb = new StringBuilder();
    
    static int N, C;
    static int[] houses;
    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static boolean determination(int D) {
        int cnt = 1, last = houses[0];
        for (int i=1; i<N; i++) {
            if (houses[i] - last >= D) {
                cnt++;
                last = houses[i];
            }
        }

        return cnt >= C;
    }

    static void process() {
        Arrays.sort(houses);
        int L=0, R=1000000000, ans=0;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
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
        C = scan.nextInt();
        houses = new int[N];
        for (int i=0; i<N; i++) {
            houses[i] = scan.nextInt();
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