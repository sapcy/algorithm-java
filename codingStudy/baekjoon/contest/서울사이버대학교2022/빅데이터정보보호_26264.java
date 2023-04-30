package codingStudy.baekjoon.contest.서울사이버대학교2022;

import java.io.*;
import java.util.StringTokenizer;

public class 빅데이터정보보호_26264 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, securityCnt, bigdataCnt;
    static String arr;

    static void input() {
        N = scan.nextInt();
        arr = scan.nextLine();

    }

    static void process() {
        int begin = 0;
        while (securityCnt + bigdataCnt < N) {
            char startAlpha = arr.charAt(begin);
            if (startAlpha == 'b') {
                bigdataCnt++;
                begin += 7;
            } else if (startAlpha == 's'){
                securityCnt++;
                begin += 8;
            }
        }

        if (bigdataCnt > securityCnt) {
            sb.append("bigdata?");
        } else if (bigdataCnt < securityCnt){
            sb.append("security!");
        } else {
            sb.append("bigdata? security!");
        }

        System.out.println(sb);
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