package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

class HappySchool {
    static StringBuilder sb = new StringBuilder();
    
    static int N, K, answer;
    static int total_cost;
    static int[] kids;
    static ArrayList<Integer>[] list;
    static int[] costs;
    
    public static void main(String[] args) {
        input();
        sort();
        pro();
        System.out.println(sb.toString());
    }

    static void pro() {
        list[0].add(kids[0]);
        rec(0, 1);
        sb.append(answer);
    }

    static void rec(int n, int index) {
        if (index == N || n >= K) {
            boolean check = true; 
            for (int i=0; i<K; i++) {
                if (list[i].size() > 0) {
                    costs[i] = list[i].get(list[i].size()-1) - list[i].get(0);
                } else {
                    check = false;
                    break;
                }
            }

            if (check) {
                int sum = 0;
                for (int i=0; i<K; i++) {
                    sum += costs[i];
                }
                if (sum > 0) {
                    // System.out.println(sum);
                    System.out.println();
                    System.out.print("result : ");
                    for (int i=0; i<K; i++) {
                        System.out.print("[" + i +  "] : ");
                        for (int j=0; j<list[i].size(); j++) {
                            System.out.print(list[i].get(j) + ", ");
                        }
                    }
                    answer = Math.min(sum, answer);
                }
            }
        } else {
            for (int i=index; i<N; i++) {
                list[n].add(kids[i]);
                rec(n, i+1);
                list[n].remove(list[n].size()-1);
                rec(n+1, i);
            }
        }
    }

    static void sort() {
        Arrays.sort(kids);
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        K = scan.nextInt();
        kids = new int[N];
        list = new ArrayList[K];
        costs = new int[K];

        for (int i=0; i<N; i++) {
            kids[i] = scan.nextInt();
        }

        for (int i=0; i<K; i++) {
            list[i] = new ArrayList<Integer>();
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