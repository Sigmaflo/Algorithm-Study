import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  static int[] dx = {1, 0, 0, -1, 1, 1, -1, -1}, dy = {0, 1, -1, 0, -1, 1, -1, 1};
  static int n, m;
  static int[][] map;
  static boolean[][] visit;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++)
        map[i][j] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    visit = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visit[i][j] && check(i, j)) {
          bfs(i, j);
          ans++;
        }
      }
    }

    System.out.print(ans);
  }

  public static boolean check(int x, int y) {
    for (int k = 0; k < 8; k++) {
      int nx = x + dx[k], ny = y + dy[k];
      if (range(nx, ny) && map[x][y] < map[nx][ny])
        return false;
    }
    return true;
  }

  public static void bfs(int x, int y) {
    visit[x][y] = true;
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(x, y));

    while (!q.isEmpty()) {
      Point p = q.poll();

      for (int k = 0; k < 8; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny] && map[p.x][p.y] >= map[nx][ny]) {
          visit[nx][ny] = true;
          q.add(new Point(nx, ny));
        }
      }
    }
  }
  
  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < m) return true;
    return false;
  }
}
