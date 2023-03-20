import java.io.*;
import java.util.*;

public class Main {
    static int N, min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] v;
    static int[] dR = {1, -1, 0, 0};
    static int[] dC = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int type = 1;
        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0)
                    continue;
                if (v[i][j])
                    continue;

                check(i, j, type);
                type++;
            }
        }

        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0)
                    continue;
                if (v[i][j])
                    continue;

                bfs(i, j, map[i][j]);
            }
        }

        System.out.println(min);
    }

    static void check(int row, int col, int type) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row, col));
        v[row][col] = true;
        map[row][col] = type;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int dr = now.row + dR[i];
                int dc = now.col + dC[i];

                if (dr < 0 || dc < 0 || dr >= N || dc >= N)
                    continue;
                if (map[dr][dc] == 0)
                    continue;
                if (v[dr][dc])
                    continue;

                v[dr][dc] = true;
                map[dr][dc] = type;
                q.offer(new Node(dr, dc));
            }
        }
    }

    static void bfs(int row, int col, int type) {
        v[row][col] = true;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(row, col, 0));

        boolean[][] visited = new boolean[N][N];
        visited[row][col] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int dr = now.row + dR[i];
                int dc = now.col + dC[i];

                if (dr < 0 || dc < 0 || dr >= N || dc >= N)
                    continue;
                if (map[dr][dc] == type) {
                    v[dr][dc] = true;
                    continue;
                }
                if (visited[dr][dc])
                    continue;

                if (map[dr][dc] == 0) {
                    q.offer(new Node(dr, dc, now.len + 1));
                    visited[dr][dc] = true;
                } else if (map[dr][dc] != type) {
                    min = Math.min(min, now.len);
                    return;
                }
            }
        }
    }
}

class Node {
    int row, col, len;

    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    Node(int row, int col, int len) {
        this.row = row;
        this.col = col;
        this.len = len;
    }
}