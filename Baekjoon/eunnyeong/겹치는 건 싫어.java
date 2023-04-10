import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    int[] cnt = new int[100001];
    int s = 0, e = 0, ans = 0;
    while (true) {
      if (e < n - 1)
        cnt[a[e]]++;
      else
        if (s < n - 1)
          cnt[a[s]]--;

      if (cnt[a[e]] > k) {
        ans = Math.max(ans, e - s);
        while(true) {
          cnt[a[s]]--;
          s++;
          if (s > 0 && a[s - 1] == a[e])
            break;
        }
      }

      if (e < n - 1)
        e++;
      else {
        if (ans == 0)
          ans = e - s + 1;
        break;
      }

      if (s == n - 1 && e == n - 1) {
        ans = Math.max(ans, e - s);
        break;
      }
    }

    System.out.print(ans);

  }
}
