import java.io.*;
import java.util.*;

public class Main {

  static int n, m, k, ans = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++)
        a[i][j] = s.charAt(j) - '0';
    }

    k = Integer.parseInt(br.readLine());

    calc(a, 0);

    System.out.print(ans);
  }

  public static int check(int[][] tmp) {
    int cnt = 0;

    for (int i = 0; i < n; i++) {
      int f = 0;
      for (int j = 0; j < m; j++) {
        if (tmp[i][j] != 1) {
          f = 1;
          break;
        }
      }
      if (f == 0) cnt++;
    }

    return cnt;
  }

  public static void calc(int[][] tmp, int cnt) {
    if (cnt == k) {
      ans = Math.max(ans, check(tmp));
      return;
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++)
        tmp[j][i] = tmp[j][i] == 0 ? 1 : 0;

      calc(tmp, cnt + 1);

      for (int j = 0; j < n; j++)
        tmp[j][i] = tmp[j][i] == 0 ? 1 : 0;
    }
  }
}
