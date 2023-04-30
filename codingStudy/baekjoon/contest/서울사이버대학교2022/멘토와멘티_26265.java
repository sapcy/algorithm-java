package codingStudy.baekjoon.contest.서울사이버대학교2022;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class 멘토와멘티_26265 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Student[] students;

    static void input() {
        N = scan.nextInt();
        students = new Student[N];

        for (int i=0; i<N; i++) {
            String next = scan.nextLine();
            students[i] = new Student(next.split(" ")[0], next.split(" ")[1]);
        }

    }

    static void process() {
        Arrays.sort(students);

        for (Student s : students) {
            sb.append(s.mento + " " + s.menti + "\n");
        }

        System.out.println(sb);
    }

    public static class Student implements Comparable<Student> {

        String mento;
        String menti;

        public Student(String mento, String menti) {
            this.mento = mento;
            this.menti = menti;
        }

        @Override
        public int compareTo(Student s) {
            if (this.mento.equals(s.mento)) {
                return s.menti.compareTo(this.menti);
            }

            return this.mento.compareTo(s.mento);
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