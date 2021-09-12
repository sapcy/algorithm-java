package binarySearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10815

public class NumberCard2 {
    static StringBuilder sb = new StringBuilder();
    
    static int N, M;
    static int[] n_arr, m_arr;
    static HashMap<Integer, Integer> map;
    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static void process() {
        Arrays.sort(n_arr);
        
        for (int i=0; i<M; i++) {
            int lower_bound = lower_bound(n_arr, 0, N-1, m_arr[i]);
            int upper_bound = upper_bound(n_arr, 0, N-1, m_arr[i]);
            sb.append(upper_bound - lower_bound).append(" ");
        }
    }

    static int lower_bound(int[] target_arr, int L, int R, int value) {
        int ans = R+1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (target_arr[mid] >= value) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return ans;
    }

    static int upper_bound(int[] target_arr, int L, int R, int value) {
        int ans = R+1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (target_arr[mid] > value) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return ans;
    }
        

    static void input() {
        FastReader scan = new FastReader();
        map = new HashMap<>();
        N = scan.nextInt();
        n_arr = new int[N];
        for (int i=0; i<N; i++) {
            n_arr[i] = scan.nextInt();
        }
        
        M = scan.nextInt();
        m_arr = new int[M];
        for (int i=0; i<M; i++) {
            m_arr[i] = scan.nextInt();
            map.put(m_arr[i], 0);
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