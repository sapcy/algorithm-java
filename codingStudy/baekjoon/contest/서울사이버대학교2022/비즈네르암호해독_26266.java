package codingStudy.baekjoon.contest.서울사이버대학교2022;

import java.io.*;
import java.util.*;

public class 비즈네르암호해독_26266 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static char[] normal, secure, keys, answer;
//    static String keys;
    static int[] intKeys;
    static int MIN_VALUE = Integer.MAX_VALUE;

    static void input() {
        String normalText = scan.nextLine();
        normal = normalText.toCharArray();
        String secText = scan.nextLine();
        secure = secText.toCharArray();
        keys = new char[normal.length];
        intKeys = new int[normal.length];
    }

    static void process() {
        for (int i=0; i<normal.length; i++) {
            if (normal[i] > secure[i]) {
                intKeys[i] = secure[i] + 26 - normal[i];
            } else {
                intKeys[i] = secure[i] - normal[i];
            }
            keys[i] = (char)(intKeys[i] + 64);
        }

        int length = keys.length;
        int sqrtNum = (int) Math.sqrt(length);
        List<Integer> list = new ArrayList();
        for (int i=1; i<=sqrtNum; i++) {
            if (length % i == 0) {
                list.add(i);
                list.add(length / i);
            }
        }

        boolean check = false;
        for (int i=0; i<list.size(); i++) {
            int target = list.get(i);
            if (target == length) continue;
            if (Arrays.equals(Arrays.copyOfRange(keys, 0, target), Arrays.copyOfRange(keys, target, target*2))) {
                char[] temp = Arrays.copyOfRange(keys, 0, target);
                if (Math.min(MIN_VALUE, temp.length) == temp.length) {
                    answer = temp;
                    MIN_VALUE = temp.length;
                }

                check = true;
            }
        }
        if (!check) {
            answer = keys;
        }

        sb.append(answer);

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