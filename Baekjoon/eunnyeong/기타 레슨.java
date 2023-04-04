import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] a = new int[n];
    int left = -1, right = 0;
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
      right += a[i];
      if (left < a[i])
        left = a[i];
    }

    while (left <= right) {
      int mid = (left + right) / 2, sum = 0, cnt = 0;
      for (int i = 0; i < n; i++) {
        if (sum + a[i] > mid) {
          sum = 0;
          cnt++;
        }
        sum += a[i];
      }
      if (sum != 0) cnt++;

      if (cnt <= m)
        right = mid - 1;
      else
        left = mid + 1;
    }
    System.out.print(left);
  }
}
