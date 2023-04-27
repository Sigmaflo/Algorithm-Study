import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());

    int[] a = new int[m + 1];
    for (int i = 0; i < m; i++)
      a[i] = Integer.parseInt(br.readLine());
    a[m] = l;

    int[] o = new int[n];
    for (int i = 0; i < n; i++)
      o[i] = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      int left = 0, right = l, ans = 0;

      while (left <= right) {
        int mid = (left + right) / 2;
        int cnt = 0, prev = 0;

        for (int j = 0; j <= m; j++) {
          if (a[j] - prev >= mid) {
            cnt++;
            prev = a[j];
          }
        }

        if (cnt > o[i]) {
          left = mid + 1;
          ans = Math.max(ans, mid);
        }
        else right = mid - 1;
      }

      sb.append(right + "\n");
    }

    bw.write(sb.toString());
    bw.flush(); bw.close(); br.close();
  }
}
