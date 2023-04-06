import java.io.*;
import java.util.*;

public class Main {

  static int n, ans = Integer.MAX_VALUE;
  static int[][] map;
  static int[] select;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    map = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        map[i][j] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= n / 2; i++) {
      select = new int[i];
      comb(0, 0, i);
    }

    System.out.print(ans);
  }

  public static void comb(int cnt, int idx, int d) {
    if (cnt == d) {
      boolean[] visit = new boolean[n];
      for (int i = 0; i < d; i++)
        visit[select[i]] = true;

      int x = 0, y = 0;
      Queue<Integer> a = new ArrayDeque<>();
      Queue<Integer> b = new ArrayDeque<>();

      for (int i = 0; i < n; i++) {
        if (visit[i]) {
          a.add(i);
        } else
          b.add(i);
      }

      int t = a.poll();
      while (!a.isEmpty()) {
        int t2 = a.poll();
        x += map[t][t2];
        x += map[t2][t];
        t = t2;
      }

      t = b.poll();
      while (!b.isEmpty()) {
        int t2 = b.poll();
        y += map[t][t2];
        y += map[t2][t];
        t = t2;
      }
      
      ans = Math.min(Math.abs(x - y), ans);
      return;
    }

    for (int i = idx; i < n; i++) {
      select[cnt] = i;
      comb(cnt + 1, i + 1, d);
    }
  }
}
