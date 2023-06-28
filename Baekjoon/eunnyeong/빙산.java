import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  static int n, m;
  static int[][] map;
  static int[] dx = {-1, 0, 0, 1}, dy = {0, 1, -1, 0};
  static boolean[][] visit;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
    ex:while (true) {
      ans++;
      minus();
      visit = new boolean[n][m];
      int f = 0, cnt = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (map[i][j] != 0) {
            if (f != 0 && !visit[i][j])
              break ex;
             bfs(i, j);
             f = 1;
          }
          else cnt++;
        }
      }

      if (cnt == n * m) {
        ans = 0;
        break;
      }
    }

    System.out.print(ans);
  }

  public static void bfs(int x, int y) {
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(x, y));
    visit[x][y] = true;

    while (!q.isEmpty()) {
      Point p = q.poll();
      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && !visit[nx][ny] && map[nx][ny] > 0) {
          visit[nx][ny] = true;
          q.add(new Point(nx, ny));
        }
      }
    }
  }

  public static void minus() {
    int[][] tmp = new int[n][m];
    for (int i = 0; i < n; i++)
      tmp[i] = Arrays.copyOf(map[i], m);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] != 0) {
          int cnt = 0;
          for (int k = 0; k < 4; k++) {
            int nx = i + dx[k], ny = j + dy[k];
            if (range(nx, ny) && map[nx][ny] == 0)
              cnt++;
          }
          tmp[i][j] -= cnt;
          if (tmp[i][j] < 0)
            tmp[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < n; i++)
      map[i] = Arrays.copyOf(tmp[i], m);
  }

  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < m) return true;
    return false;
  }
}
