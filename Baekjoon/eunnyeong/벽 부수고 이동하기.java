import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  static int n, m, ans = Integer.MAX_VALUE;
  static int[][] map;
  static int[] dx = {0, 1, -1, 0}, dy = {1, 0, 0, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++)
        map[i][j] = s.charAt(j) - '0';
    }

    bfs();

    if (ans == Integer.MAX_VALUE)
      ans = -1;
    System.out.print(ans);
  }

  public static void bfs() {
    boolean[][] visit = new boolean[n][m];
    Queue<Node> q = new ArrayDeque<>();
    q.add(new Node(0, 0, 0, 1));
    visit[0][0] = true;

    while (!q.isEmpty()) {
      Node p = q.poll();
      if (p.x == n - 1 && p.y == m - 1) {
        ans = Math.min(ans, p.cnt);
        break;
      }
      for (int k = 0; k < 4; k++) {
        int nx  = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny]) {
          visit[nx][ny] = true;
          if (map[nx][ny] == 0)
            q.add(new Node(nx, ny, p.f, p.cnt + 1));
          if (map[nx][ny] == 1 && p.f == 0)
            q.add(new Node(nx, ny, p.f + 1, p.cnt + 1));
          if (p.f == 1 || map[nx][ny] == 1)
            visit[nx][ny] = false;
        }
      }
    }

  }

  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < m) return true;
    else return false;
  }

  static class Node {
    int x, y, f, cnt; //깼는지 여부, 지나온 칸 수
    public Node(int x, int y, int f, int cnt) {
      this.x = x;
      this.y = y;
      this.f = f;
      this.cnt = cnt;
    }
  }
}
