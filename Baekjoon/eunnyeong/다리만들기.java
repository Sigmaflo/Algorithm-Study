import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
  static int[] dx = {0, 1, -1, 0}, dy = {1, 0, 0, -1};
  static int n, ans = Integer.MAX_VALUE;
  static int[][] map;
  static boolean[][] visit;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    map = new int[n][n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        map[i][j] = Integer.parseInt(st.nextToken());
    }

    int idx = 2;
    visit = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 1 && !visit[i][j]) {
          bfs(new Point(i, j), idx);
          idx++;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] > 1) {
          visit = new boolean[n][n];
          bridge(new Len(i, j, 0), map[i][j]);
        }
      }
    }

    System.out.print(ans);
  }

  public static void bfs(Point s, int idx) {
    Queue<Point> q = new ArrayDeque<>();
    q.add(s);
    map[s.x][s.y] = idx;
    visit[s.x][s.y] = true;

    while (!q.isEmpty()) {
      Point p = q.poll();

      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny] && map[nx][ny] == 1) {
          map[nx][ny] = idx;
          visit[nx][ny] = true;
          q.add(new Point(nx, ny));
        }
      }
    }
  }

  public static void bridge(Len l, int idx) {
    Queue<Len> q = new ArrayDeque<>();
    q.add(l);
    visit[l.x][l.y] = true;

    while (!q.isEmpty()) {
      Len p = q.poll();
      if (ans <= p.cnt) continue;
      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny] && map[nx][ny] != idx) {
          if (map[nx][ny] == 0) {
            q.add(new Len(nx, ny, p.cnt + 1));
            visit[nx][ny] = true;
          }
          else
            ans = Math.min(ans, p.cnt);
        }
      }
    }
  }

  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < n) return true;
    return false;
  }

  static class Len{
    int x, y, cnt;
    public Len(int x, int y, int cnt) {
      this.x = x;
      this.y = y;
      this.cnt = cnt;
    }
  }
}
