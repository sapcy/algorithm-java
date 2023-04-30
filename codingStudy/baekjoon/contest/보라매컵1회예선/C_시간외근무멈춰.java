package codingStudy.baekjoon.contest.보라매컵1회예선;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/27112

public class C_시간외근무멈춰 {
    static StringBuilder sb = new StringBuilder();
    
    static int N, maxDate, sum, minTaskTime, answer;
    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static void process() {
        Collections.sort(tasks);

        for (Task t : tasks) {
//            maxDate = Math.max(t.endDate, maxDate);
            sum += t.processTime;

            int enableTaskFullTime = (t.endDate * 2) - ((t.endDate / 7) * 2);

            if (sum > t.endDate) {
                answer += sum - t.endDate;
            } else if (sum > enableTaskFullTime){
                sb.append(-1);
                break;
            }

//            if (sum > enableTaskFullTime) {
//                sb.append(-1);
//                break;
//            } else {
//                if (t.endDate < 7) {
//                    minTaskTime = t.endDate == 6 ? 5 : t.endDate;
//                } else {
//                    minTaskTime = (t.endDate / 7) * 5 + (t.endDate % 7 == 6 ? 5 : t.endDate % 7);
//                }
//            }
        }
        sb.append(answer);

//        int enableTaskFullTime = (maxDate * 2) - ((maxDate / 7) * 2);
//        if (sum > enableTaskFullTime) {
//            sb.append(-1);
//        } else {
//            int minTaskTime;
//            if (maxDate < 7) {
//                minTaskTime = maxDate == 6 ? 5 : maxDate;
//            } else {
//                minTaskTime = (maxDate / 7) * 5 + (maxDate % 7 == 6 ? 5 : maxDate % 7);
//            }
//            sb.append(sum - minTaskTime);
//        }
    }
        

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        for (int i=0; i<N; i++) {
            String next = scan.nextLine();
            int endDate = Integer.parseInt(next.split(" ")[0]);
            int taskTime = Integer.parseInt(next.split(" ")[1]);
//            maxDate = Math.max(endDate, maxDate);
//            sum += taskTime;
            tasks.add(new Task(endDate, taskTime));
        }
    }

    static class Task implements Comparable<Task> {
        public int endDate;
        public int processTime;

        public Task(int endDate, int processTime) {
            this.endDate = endDate;
            this.processTime = processTime;
        }

        @Override
        public int compareTo(Task t) {
            return this.endDate - t.endDate;
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