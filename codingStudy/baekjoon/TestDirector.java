package codingStudy.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3190

public class TestDirector {
    static StringBuilder sb = new StringBuilder();
    
    static int N, B, C;
    static int[] testRooms;

    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static void process() {
        long monitorNum = N;
        for (int i=0; i<N; i++) {
            int requiredMonitor = testRooms[i] - B;

            if (requiredMonitor > 0) {
                // 한번에 감독할 수 있는 횟수로 나눈 값의 나머지가 있을 때 부감독 한명 더 추가
                if (requiredMonitor/C == 0 && requiredMonitor%C > 0 || requiredMonitor/C != 0 && requiredMonitor%C > 0) {
                    monitorNum += requiredMonitor/C + 1;
                } else if (requiredMonitor/C != 0 && requiredMonitor%C == 0){
                    monitorNum += requiredMonitor/C;
                }
            }

        }

        sb.append(monitorNum);
    }
        

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        testRooms = new int[N];
        String[] testRoomInfo = scan.nextLine().split(" ");
        for (int i=0; i<N; i++) {
            testRooms[i] = Integer.parseInt(testRoomInfo[i]);
        }
        String BC = scan.nextLine();
        B = Integer.parseInt(BC.split(" ")[0]);
        C = Integer.parseInt(BC.split(" ")[1]);
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