import java.io.*;
import java.util.*;

public class Main {

  static int[] fx1 = {-1, 1, 0, 0}, fy1 = {0, 0, 1, -1}; //물건 1
  static int[] fx2 = {1, -1, 0, 0}, fy2 = {0, 0, -1, 1}; //물건 2
  static int[] fx3 = {0, 0, 1, -1}, fy3 = {1, -1, 0, 0}; //물건 3
  static int[] fx4 = {0, 0, -1, 1}, fy4 = {-1, 1, 0, 0}; //물건 4
  static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
  static int n, m;
  static int[][] map;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    Node s = new Node(-1, -1, -1);
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0 ; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 9)
          s = new Node(i, j, -1);
      }
    }

    bfs(s);
  }

  public static void bfs(Node s) {
    boolean[][] visit = new boolean[n][m];
    visit[s.x][s.y] = true;
    Queue<Node> q = new ArrayDeque<>();
    q.add(s);

    int cnt = 0;
    while(!q.isEmpty()) {
      cnt++;
      Node p = q.poll();
      System.out.println(p.x + " " + p.y + " " + p.d);
      int x = map[p.x][p.y];
      int nx = p.x, ny = p.y;
      if (x == 0 || x == 9) {
        for (int k = 0; k < 4; k++) {
          nx += dx[k]; ny += dy[k];
          if (range(nx, ny) && !visit[nx][ny]) {
            q.add(new Node(nx, ny, k));
            visit[nx][ny] = true;
          }
        }
      }
      else {
        while (true) {
          if (x == 1) {
            nx += fx1[p.d];
            ny += fy1[p.d];
          }
          if (x == 2) {
            nx += fx2[p.d];
            ny += fy2[p.d];
          }
          if (x == 3) {
            nx += fx3[p.d];
            ny += fy3[p.d];
          }
          if (x == 4) {
            nx += fx4[p.d];
            ny += fy4[p.d];
          }

          if (range(nx, ny) && !visit[nx][ny]) {
            q.add(new Node(nx, ny, p.d));
            visit[nx][ny] = true;
          }
          else break;
        }
      }
    }

    System.out.print(cnt);
  }

  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < m) return true;
    return false;
  }

  static class Node {
    int x, y, d;

    public Node(int x, int y, int d) {
      this.x = x;
      this.y = y;
      this.d = d;
    }
  }
}
