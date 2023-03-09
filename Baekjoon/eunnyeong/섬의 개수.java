import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

  static int w, h;
  static int[][] map;
  static int[] dx = {0,-1, 1, 0, 1, 1, -1, -1}, dy = {1, 0, 0, -1, 1, -1, 1, -1};
  static boolean[][] visit;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringBuilder sb = new StringBuilder();
    w = -1; h = -1;
    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      if (w == 0 && h == 0) break;

      int cnt = 0;
      map = new int[h][w];
      for (int i = 0; i < h; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < w; j++)
          map[i][j] = Integer.parseInt(st.nextToken());
      }

      visit = new boolean[h][w];
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (!visit[i][j] && map[i][j] == 1) {
            bfs(new Point(i, j));
            cnt++;
          }
        }
      }

      sb.append(cnt + "\n");
    }
    bw.write(sb.toString());
    bw.flush(); bw.close(); br.close();
  }

  public static void bfs(Point s) {
    Queue<Point> q = new ArrayDeque<>();
    q.add(s);
    visit[s.x][s.y] = true;

    while (!q.isEmpty()) {
      Point p = q.poll();
      for (int k = 0; k < 8; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];

        if (range(nx, ny) && !visit[nx][ny] && map[nx][ny] == 1) {
          visit[nx][ny] = true;
          q.add(new Point(nx, ny));
        }
      }
    }
  }

  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < h && ny >= 0 && ny < w) return true;
    return false;
  }
}
