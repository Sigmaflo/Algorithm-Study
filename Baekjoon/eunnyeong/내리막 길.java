import java.io.*;
import java.util.*;

public class Main {

  static int n, m, ans = 0;
  static int[][] map, visit;
  static int[] dx = {0, 1, -1, 0}, dy = {1, 0, 0, -1};

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

    visit = new int[n][m];
    bfs();
    System.out.print(visit[n - 1][m - 1]);
  }

  public static void bfs() {
    PriorityQueue<Point> q = new PriorityQueue<>();
    q.add(new Point(0, 0, map[0][0]));
    visit[0][0] = 1;

    while (!q.isEmpty()) {
      Point p = q.poll();
      for (int k = 0; k < 4; k++) {
        int nx = p.x + dx[k], ny = p.y + dy[k];
        if (range(nx, ny) && map[p.x][p.y] > map[nx][ny]) {
          if (visit[nx][ny] == 0)
            q.add(new Point(nx, ny, map[nx][ny]));
          visit[nx][ny] += visit[p.x][p.y];
        }
      }
    }
  }

  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < m) return true;
    return false;
  }

  static class Point implements Comparable<Point> {
    int x, y, weight;

    public Point(int x, int y, int weight) {
      this.x = x;
      this.y = y;
      this.weight = weight;
    }

    @Override
    public int compareTo(Point o) {
      return o.weight - this.weight;
    }
  }
}
