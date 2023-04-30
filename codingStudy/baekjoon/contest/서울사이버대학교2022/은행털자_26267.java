package codingStudy.baekjoon.contest.서울사이버대학교2022;

import java.io.*;
import java.util.*;

public class 은행털자_26267 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long answer;
    static Bank[] banks;
    static HashMap<Integer, Long> hashMap = new HashMap();

    static void input() {
        N = scan.nextInt();
        banks = new Bank[N];
        for (int i=0; i<N; i++) {
            banks[i] = new Bank(scan.nextInt(), scan.nextInt(), scan.nextInt());
        }
    }

    static void process() {
        for (int i=0; i<N; i++) {
            if (hashMap.containsKey(banks[i].time - banks[i].dist)) {
                hashMap.put(banks[i].time - banks[i].dist, hashMap.get(banks[i].time - banks[i].dist) + banks[i].money);
            } else {
                hashMap.put(banks[i].time - banks[i].dist, (long)banks[i].money);
            }
        }

        for (Long i : hashMap.values()) {
            answer = Math.max(i, answer);
        }

        System.out.println(answer);
    }

    static class Bank {
        int dist;
        int time;
        int money;
        int value;

        public Bank(int dist, int time, int money) {
            this.dist = dist;
            this.time = time;
            this.money = money;
        }
    }

    public static void main(String[] args) {
        input();
        process();
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