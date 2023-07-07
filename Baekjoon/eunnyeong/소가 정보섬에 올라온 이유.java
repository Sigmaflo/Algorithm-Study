import java.io.*;
import java.util.*;

public class Main {

  static int n, q;
  static int[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    q = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    a = new int[n + 1];
    for (int i = 1; i <= n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    StringBuilder sb = new StringBuilder();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < q; i++) {
      int x = Integer.parseInt(st.nextToken());
      a[x] *= -1;

      Queue<Integer> q = new ArrayDeque<>();
      for (int j = 1; j <= n; j++)
        q.add(a[j]);

      int sum = 1, ans = 0;
      for (int j = 0; j < 4; j++) {
        int p = q.poll();
        sum *= p;
        if (j != 3)
          q.add(p);
      }

      ans += sum;

      int idx = 1;
      while (!q.isEmpty()) {
        sum /= a[idx++];
        sum *= q.poll();
        ans += sum;
      }

      sb.append(ans + "\n");
    }

    bw.write(sb.toString());
    bw.flush(); bw.close(); br.close();
  }
}
