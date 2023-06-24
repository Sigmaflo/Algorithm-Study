import java.io.*;
import java.util.*;

public class Main {

  static int n, m, ans = Integer.MAX_VALUE;
  static int[] dx = {1, 1, 1}, dy = {-1, 0, 1};
  static int[][] map;

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

    for (int i = 0; i < m; i++)
      dfs(0, i, -1, map[0][i]);

    System.out.print(ans);
  }

  public static void dfs(int x, int y, int before, int cnt) {
    if (x == n - 1) {
      ans = Math.min(ans, cnt);
      return;
    }

    for (int k = 0; k < 3; k++) {
      if (before != k) {
        int nx = x + dx[k], ny = y + dy[k];
        if (nx < n && nx >= 0 && ny >= 0 && ny < m)
          bfs(nx, ny, k, cnt + map[nx][ny]);
      }
    }
  }
}
