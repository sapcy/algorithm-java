package codingStudy.baekjoon.contest.보라매컵1회예선;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/27114

public class E_조교의맹연습 {
    static StringBuilder sb = new StringBuilder();
    
    static int K, result, goalEnergy, answer;
//    static int[] energies, selected;
    static Energy[] energies;
    static int[][] step = {{0,1},{0,2},{1,2}};

    public static void main(String[] args) {
        input();
        process();
        System.out.println(sb.toString());
    }

    static void process() {
        // only A or B or C
        for (int i=0; i<3; i++) {
            int rotateResult = 0;
            if (K / energies[i].value > 0 && K % energies[i].value == 0) {
                for (int j=0; j<K/energies[i].value; j++) {
                    rotateResult = rotate(i, rotateResult);
                }
                if (result == 0) {
                    sb.append(K/energies[i].value);
                    return;
                }
            }
        }

        // A,B or A,C or B,C
        for (int i=0; i<step.length; i++) {
            int rotateResult = 0;
            if (energies[step[i][0]].value > energies[step[i][1]].value) {
                int rest = K % energies[step[i][0]].value;
                int restOfRest = rest % energies[step[i][1]].value;

                if (restOfRest == 0) {
                    for (int j=0; j<K/energies[step[i][0]].value; j++) {
                        rotateResult = rotate(i, rotateResult);
                    }
                    if (rotateResult == 0) {
                        sb.append(K/energies[i].value);
                        return;
                    }
                }
            } else {
                int rest = K % energies[step[i][1]].value;
                int restOfRest = rest % energies[step[i][0]].value;

                if (restOfRest == 0) {
                    for (int j=0; j<K/energies[step[i][1]].value; j++) {
                        rotateResult = rotate(i, rotateResult);
                    }
                    if (rotateResult == 0) {
                        sb.append(K/energies[i].value);
                        return;
                    }
                }
            }
        }

        // A,B,C
        int[] sortedIndex = {0,1,2};
        int[] sortedValue = new int[3];



//        for (int i=0; i<3; i++) {
//            if (energies[i].value > maxValue) {
//                maxIndex = i;
//                maxValue = energies[i];
//            }
//        }

    }

    static int rotate(int index, int rotateResult) {
        switch (index) {
            case 0: {
                if (rotateResult > 0 && rotateResult < 4) rotateResult -= 1;
                else if (rotateResult == 0) rotateResult = 3;
                break;
            }
            case 1: {
                if (rotateResult >= 0 && rotateResult < 4) rotateResult += 1;
                break;
            }
            case 2: {
                if (rotateResult >= 0 && rotateResult < 3) rotateResult += 2;
                else if (rotateResult == 3) rotateResult = 1;
                break;
            }
        }

        if (rotateResult == 4) return 0;

        return rotateResult;
    }

    static class Energy implements Comparable<Energy> {
        public int index;
        public int value;

        public Energy(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Energy t) {
            return t.value - this.value;
        }
    }

    static void input() {
        FastReader scan = new FastReader();
        K = scan.nextInt();
        String next = scan.nextLine();
        energies = new Energy[3];
//        selected = new int[3];
        for (int i=0; i<3; i++) {
            energies[i].index = i;
            energies[i].value = Integer.parseInt(next.split(" ")[i]);
        }

        goalEnergy = Integer.parseInt(next.split(" ")[3]);
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