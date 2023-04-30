package codingStudy.baekjoon.contest.보라매컵1회예선;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/27113

public class D_잠입 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();
    
    static int N, M;
    static int[] temp, choi;

    public static void main(String[] args) {
        input();
        int result = process();
        if (result < 0) {
            sb.append("NO");
        } else {
            sb.append("YES");
        }
        System.out.println(sb.toString());
    }

    static int move(int start, int end) {
        if (start == 0 && end == 0) {
            choi[0]++;
            return 1;
        }

        if (choi[0]+1 < N) {
            if (choi[1] < start || choi[1] > end) {
                choi[0]++;
            } else if (choi[1] >= start && choi[1] <= end) {
                if (end+1 <= M) {
                    choi[1] = end+1;
                } else {
                    return -1;
                }
            }
        }

        return 1;
    }

    static int move(int start, int end, int start2, int end2) {
        if (choi[0]+1 < N) {
            if (choi[1] < start2 && choi[1] > end) {
                choi[0]++;
            } else if (choi[1] >= start && choi[1] <= end) {
                if (end+1 <= M && end+1 < start2) {
                    choi[1] = end+1;
                } else {
                    return -1;
                }
            }
        }

        return 1;
    }

    static int process() {
        choi = new int[]{1, 1};

        for (int i=1; i<N; i++) {
            String next2 = scan.nextLine();
            if (Integer.parseInt(next2.split(" ")[0]) == 0) {
                move(0,0);
            }
            for (int j=0; j<Integer.parseInt(next2.split(" ")[0]); j++) {
                int num;
                String dir;
                if (j==0) {
                    num = Integer.parseInt(next2.split(" ")[j+1]);
                    dir = next2.split(" ")[j+2];
                } else {
                    num = Integer.parseInt(next2.split(" ")[j+2]);
                    dir = next2.split(" ")[j+3];
                }

                // 단방향 레이저
                if (Integer.parseInt(next2.split(" ")[0]) == 1) {
                    if (dir.equals("R")) {
                        if (move(num, M) < 0) {
                            return -1;
                        }
                    } else if (dir.equals("L")){
                        if (move(1, num) < 0) {
                            return -1;
                        }
                    }
                } else if (Integer.parseInt(next2.split(" ")[0]) == 2) {
                    if (j==0) {
                        temp[0] = dir.equals("R") ? 1 : 0;
                        temp[1] = num;
                    } else {
                        // R R
                        if (dir.equals("R") && temp[0] == 1) {
                            if (move(Math.min(temp[1], num), M) < 0) {
                                return -1;
                            }
                            // L L
                        } else if (dir.equals("L") && temp[0] == 0) {
                            if (move(1, Math.max(temp[1], num)) < 0) {
                                return -1;
                            }
                        } else {
                            // R L
                            if (dir.equals("L") && temp[0] == 1) {
                                // -> <- 만나는 레이저
                                if (temp[1] < num) {
                                    if (move(temp[1], num) < 0) return -1;
                                } else {
                                    // <- ->
                                    if (move(1, num, temp[1], M) < 0) return -1;
                                }
                            }
                            // L R
                            else if (dir.equals("R") && temp[0] == 0) {
                                // -> <- 만나는 레이저
                                if (temp[1] > num) {
                                    if (move(num, temp[1]) < 0) return -1;
                                } else {
                                    // <- ->
                                    if (move(1, temp[1], num, M) < 0) return -1;
                                }
                            }
                        }
                    }
                }

            }
        }

        if (choi[0] == N && choi[1] == M) {
            return 1;
        } else {
            return -1;
        }
    }
        

    static void input() {
        String next = scan.nextLine();
        N = Integer.parseInt(next.split(" ")[0]);
        M = Integer.parseInt(next.split(" ")[1]);
        temp = new int[2];
//        grid = new int[N+1][M+1];

//        for (int i=1; i<N; i++) {
//            String next2 = scan.nextLine();
//            for (int j=0; j<Integer.parseInt(next2.split(" ")[0]); j++) {
//                int num;
//                String dir;
//                if (j==0) {
//                    num = Integer.parseInt(next2.split(" ")[j+1]);
//                    dir = next2.split(" ")[j+2];
//                } else {
//                    num = Integer.parseInt(next2.split(" ")[j+2]);
//                    dir = next2.split(" ")[j+3];
//                }
//
//                // 단방향 레이저
//                if (Integer.parseInt(next2.split(" ")[0]) == 1) {
//                    if (dir.equals("R")) {
//                        for (int k=num; k<M+1; k++) {
//                            grid[i+1][k] = 1;
//                        }
//                    } else if (dir.equals("L")){
//                        for (int k=num; k>0; k--) {
//                            grid[i+1][k] = 1;
//                        }
//                    }
//                } else if (Integer.parseInt(next2.split(" ")[0]) == 2) {
//                    if (j==0) {
//                        temp[0] = dir.equals("R") ? 1 : 0;
//                        temp[1] = num;
//                    } else {
//                        // R R
//                        if (dir.equals("R") && temp[0] == 1) {
//                            for (int k=Math.min(temp[1], num); k<M; k++) {
//                                grid[i+1][k] = 1;
//                            }
//                            // L L
//                        } else if (dir.equals("L") && temp[0] == 0) {
//                            for (int k=Math.max(temp[1], num); k>0; k--) {
//                                grid[i+1][k] = 1;
//                            }
//                        } else {
//                            // R L
//                            if (dir.equals("L") && temp[0] == 1) {
//                                // -> <- 만나는 레이저
//                                if (temp[1] < num) {
//                                    for (int k=temp[1]; k<=num; k++) {
//                                        grid[i+1][k] = 1;
//                                    }
//                                } else {
//                                    // <- ->
//                                    // R
//                                    for (int k=temp[1]; k<M; k++) {
//                                        grid[i+1][k] = 1;
//                                    }
//                                    // L
//                                    for (int k=num; k>0; k--) {
//                                        grid[i+1][k] = 1;
//                                    }
//                                }
//                            }
//                            // L R
//                            else if (dir.equals("R") && temp[0] == 0) {
//                                // -> <- 만나는 레이저
//                                if (temp[1] > num) {
//                                    for (int k=num; k<=temp[1]; k++) {
//                                        grid[i+1][k] = 1;
//                                    }
//                                } else {
//                                    // <- ->
//                                    // L
//                                    for (int k=temp[1]; k>0; k--) {
//                                        grid[i+1][k] = 1;
//                                    }
//                                    // R
//                                    for (int k=num; k<M; k++) {
//                                        grid[i+1][k] = 1;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//
//            }
//        }
//
//        while (true) {
//            // 오른쪽으로
//            if (grid[choi[0]+1][choi[1]] == 1 && grid[choi[0]+1][choi[1]] == 0) {
//                if (grid[choi[0]][choi[1]+1] != 1) {
//                    if (choi[1]+1 <= M) choi[1]++;
//                }
//                // 밑으로
//            } else if (grid[choi[0]+1][choi[1]] == 0 && grid[choi[0]+1][choi[1]] == 1) {
//                if (choi[0]+1 <= N) {
//                    choi[0]++;
//                }
//            } else if (grid[choi[0]+1][choi[1]] == 1 && grid[choi[0]+1][choi[1]] == 1) {
//                if (choi[0] == N && choi[1] == M) {
//                    sb.append("YES");
//                } else {
//
//                }
//            }
//
//            if ()
//        }

//        for (int i=0; i<N+1; i++) {
//            for (int j=0; j<M+1; j++) {
//                if (i==0 || j==0) continue;
//                System.out.print(grid[i][j] + " ");
//            }
//            System.out.println();
//        }
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