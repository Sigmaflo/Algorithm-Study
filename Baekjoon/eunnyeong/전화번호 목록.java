import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int tc = 0; tc < t; tc++) {
      int n = Integer.parseInt(br.readLine());
      String[] a = new String[n];

      for (int i = 0; i < n; i++)
        a[i] = br.readLine();

      Arrays.sort(a);

      int f = 0;
      for (int i = 0; i < n - 1; i++) {
        int x = a[i].length();
        int y = a[i + 1].length();
        if (x < y) {
          if (a[i].equals(a[i + 1].substring(0, x))) {
            sb.append("NO\n");
            f = 1;
            break;
          }
        }
      }

      if (f == 0)
        sb.append("YES\n");
    }

    bw.write(sb.toString());
    bw.flush(); bw.close(); br.close();
  }
}
