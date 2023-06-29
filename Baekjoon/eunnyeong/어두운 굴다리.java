import java.io.*;
import java.util.*;

public class Main {

  static int n, m, ans;
  static int[] x;
  static boolean[] visit;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    x = new int[m];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++)
      x[i] = Integer.parseInt(st.nextToken());

    HashMap<Integer,Boolean>h = new HashMap<>();
    for (int i = 0; i < n; i++)
      h.put(i, false);

    ans = Integer.MAX_VALUE;
    dfs(h, 0);
    System.out.print(ans);
  }

  public static void dfs(HashMap<Integer, Boolean> h, int d) {
    if (!h.containsValue(false)) {
      ans = Math.min(ans, d);
      return;
    }

    for (int i = 0; i < m; i++) {
      int t = x[i] - d - 1;
      if (t >= 0)
        h.put(t, true);
      t = x[i] + d;
      if (t < n)
        h.put(t, true);
    }

    dfs(h, d + 1);
  }
}
