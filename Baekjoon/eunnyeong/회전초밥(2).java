import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int[] list = new int[n];
    for (int i = 0; i < n; i++)
      list[i] = Integer.parseInt(br.readLine());

    int ans = Integer.MIN_VALUE;
    int x = 0;
    for (int i = 0; i < n; i++) {
     boolean[] visit = new boolean[d + 1];
     int s = 0;
      for (int j = x; j < k + x; j++) {
        if (!visit[list[j % n]]) {
          s++;
          visit[list[j % n]] = true;
        }
      }
      x++;
      if (!visit[c])
        s++;
      ans = Math.max(ans, s);
    }

    System.out.print(ans);
  }
}
