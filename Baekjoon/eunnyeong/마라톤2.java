import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
  static int[][] a, dp;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    Point[] t = new Point[n + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      t[i] = new Point(x, y);
    }

    a = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++)
      for (int j = i + 1; j <= n; j++)
        a[i][j] = Math.abs(t[i].x - t[j].x) + Math.abs(t[i].y - t[j].y);

      dp = new int[n + 1][n + 1];
      for (int i = 0; i <= n; i++)
        Arrays.fill(dp[i], -1);
      System.out.print(dp(n, k));
  }

  public static int dp(int n, int k) {
    int x = dp[n][k];
    if (x != -1) return x;
    if (n == 1) return 0;

    x = Integer.MAX_VALUE;
    for (int i = 0; i <= k; i++)
      if (1 <= n - i - 1)
        x = Math.min(dp(n - i - 1, k - i) + a[n - i - 1][n], x);

    return x;
  }
}
