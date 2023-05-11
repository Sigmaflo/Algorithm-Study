import java.io.*;
import java.util.*;

public class Main {

  static int ans, x, y;
  static int[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    for (int k = 0; k < t; k++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());

      a = new int[]{-1, 0, 1};
      ans = 0;
      calc(0, x, 2);
      System.out.println(ans);
    }
  }
  public static void calc(int cnt, int n, int idx) {
    if (n == y || n == y - 1 || n > y) {
      cnt++;
      ans = cnt;
      return;
    }

    n += a[idx];
    for (int i = 0; i < 3; i++)
      a[i]++;

    calc(cnt + 1, n, idx);
  }
}
