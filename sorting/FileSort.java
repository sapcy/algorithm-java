package sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/20291

public class FileSort {
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static FileExtend[] fileExtends;
    static HashMap<String, Integer> fileExtendMap = new HashMap<>();;
    
    public static void main(String[] args) {
        input();
        sort();
        for (int i=0; i<fileExtends.length; i++) {
            sb.append(fileExtends[i].name).append(" ").append(fileExtends[i].cnt).append("\n");
            
        }
        System.out.println(sb.toString());
    }

    static void sort() {
        Iterator<String> it = fileExtendMap.keySet().iterator();
        int i=0;
        while (it.hasNext()) {
            String extend = it.next();
            fileExtends[i] = new FileExtend(extend, fileExtendMap.get(extend));
            i++;
        }

        Arrays.sort(fileExtends);
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();

        for (int i=0; i<N; i++) { 
            String extend = scan.nextLine().split("\\.")[1];
            if (fileExtendMap.containsKey(extend)) {
                fileExtendMap.put(extend, fileExtendMap.get(extend)+1);
            } else {
                fileExtendMap.put(extend, 1);
            }
        }

        fileExtends = new FileExtend[fileExtendMap.size()];
    }

    static class FileExtend implements Comparable<FileExtend> {
        String name;
        int cnt;

        public FileExtend(String name, int cnt) {
            this.name = name;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(FileExtend f) {
            return this.name.compareTo(f.name);
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