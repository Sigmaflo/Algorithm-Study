import java.io.*;
import java.util.*;

public class Main {

  static int n, ans = 0;
  static int[] a, select;
  static boolean[] visit;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    a = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    select = new int[n];
    visit = new boolean[n];
    perm(0);

    System.out.print(ans);
  }
  
  public static void perm(int cnt) {
    if (cnt == n) {
      int sum = 0;
      
      for (int i = 0; i < n - 1; i++)
        sum += Math.abs(select[i] - select[i + 1]);

      ans = Math.max(ans, sum);
    }

    for (int i = 0; i < n; i++) {
      if (!visit[i]) {
        visit[i] = true;
        select[cnt] = a[i];
        perm(cnt + 1);
        visit[i] = false;
      }
    }
  }
}
