import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int result = -1;
    static boolean[][][] v;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[2][N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(result);
    }

    private static void bfs() {

        Queue<node> q = new LinkedList<>();

        q.add(new node(0, 0, 1, 0));
        v[0][0][0] = true;
        v[1][0][0] = true;

        while (!q.isEmpty()) {
            node cur = q.poll();

            if (cur.r == N - 1 && cur.c == M - 1) {
                result = cur.time;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!check(nr, nc)) continue;

                if (map[nr][nc] == 0) {
                    if(!v[cur.destroy][nr][nc]) {
                        v[cur.destroy][nr][nc] = true;
                        q.add(new node(nr, nc, cur.time + 1, cur.destroy));
                    }
                } else  {
                    if (!v[1][nr][nc] &&cur.destroy==0) {
                        v[1][nr][nc] = true;
                        q.add(new node(nr, nc, cur.time + 1, 1));
                    }
                }
            }
        }
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static class node {
        int r;
        int c;
        int time;
        int destroy;

        public node(int r, int c, int time, int destroy) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.destroy = destroy;
        }

    }
}