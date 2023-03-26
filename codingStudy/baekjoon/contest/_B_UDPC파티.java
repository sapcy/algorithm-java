package codingStudy.baekjoon.contest;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// https://www.acmicpc.net/contest/problem/970/2

public class _B_UDPC파티 {
    static StringBuilder sb = new StringBuilder();
    
    static String V;
    static int max;
    static char[] votes;
    static Voter[] voters;
    
    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static void process() {
        if (votes.length == 2 && !V.contains("C")) {
            if (V.contains("D") && V.contains("U") || V.contains("P") && V.contains("U")) {
                sb.append("C");
                return;
            }
        }
        for (int i=0; i<votes.length; i++) {
            switch (votes[i]) {
                case 'U':
                case 'C': {
                    voters[0].voteCount++;
                    voters[3].voteCount++;
                    break;
                }
                case 'D':
                case 'P': {
                    voters[1].voteCount++;
                    voters[2].voteCount++;
                    break;
                }
            }
        }

        for (int i=0; i<voters.length; i++) {
            max = Math.max(max, voters[i].voteCount);
        }

        for (int i=0; i<voters.length; i++) {
            if (voters[i].voteCount == max) {
                if (voters[i].name == 'C') {
                    if (sb.length() == 0) sb.append(voters[i].name);
                } else {
                    sb.append(voters[i].name);
                }
            }
        }
    }


    static void input() {
        FastReader scan = new FastReader();
        V = scan.nextLine();
        votes = V.toCharArray();
        voters = new Voter[4];
        voters[0] = new Voter('U', 0);
        voters[1] = new Voter('D', 0);
        voters[2] = new Voter('P', 0);
        voters[3] = new Voter('C', 0);
    }

    static class Voter {
        char name;
        int voteCount;

        public Voter(char name, int voteCount) {
            this.name = name;
            this.voteCount = voteCount;
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