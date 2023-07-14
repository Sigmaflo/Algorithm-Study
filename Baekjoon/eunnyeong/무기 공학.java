import java.io.*;
import java.util.*;

public class Main {

  static int n, m, ans = 0;
  static int[][] a, dx = {{0, 1}, {-1, 0}, {-1, 0},{0, 1}}, dy = {{-1, 0}, {0, -1}, {0, 1},{1, 0}};
  static int[] mx = {1, -1, -1, 1}, my = {-1, -1, 1, 1};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    a = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    boolean[][] visit = new boolean[n][m];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        dfs(i, j, visit, 0);

    System.out.println(ans);
  }

  public static void dfs(int x, int y, boolean[][] visit, int cnt) {
    if (visit[x][y]) return;
    visit[x][y] = true;
    int sum = a[x][y] * 2;

    for (int i = 0; i < 4; i++) {
      int f = 0;
      for (int j = 0; j < 2; j++) {
        int nx = x + dx[i][j], ny = y + dy[i][j];
        if (range(nx, ny) && !visit[nx][ny])
          f++;
      }

      if (f == 2) { //두 방향 모두 유효한 경우
        for (int j = 0; j < 2; j++) {
          int nx = x + dx[i][j], ny = y + dy[i][j];
          if (range(nx, ny) && !visit[nx][ny]) {
            visit[nx][ny] = true;
            sum += a[nx][ny];
          }
        }

        int nx = x + mx[i], ny = y + my[i];
        if (range(nx, ny) && !visit[nx][ny]) { //합계계산
          ans = Math.max(ans, cnt + sum);
          dfs(nx, ny, visit, cnt + sum);
        }

        for (int j = 0; j < 2; j++) { //뒷 순서를 위한 방문처리 해제
          nx = x + dx[i][j]; ny = y + dy[i][j];
          visit[nx][ny] = false;
        }
      }
    }
  }

  public static boolean range(int nx, int ny) {
    if (nx >= 0 && nx < n && ny >= 0 && ny < m) return true;
    return false;
  }
}
