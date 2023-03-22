import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    String[] s = new String[n];
    int total = 0;
    for (int i = 0; i < n; i++) {
      s[i] = br.readLine();
      total += s[i].length();
    }

    int t = m - total;
    int x = t / (n - 1);
    int num = t - x * (n - 1);

    for (int i = 0; i < n - 1; i++)
      for (int j = 0; j < x; j++)
        s[i] += '_';

    boolean[] visit = new boolean[n];

    for (int i = 1; i < n; i++) {
        if (num == 0) break;
        if (Character.isLowerCase(s[i].charAt(0)) && !visit[i - 1]) {
          num--;
          s[i - 1] += '_';
          visit[i - 1] = true;
        }
    }

    for (int i = n - 1; i > 0; i--) {
      if (num == 0) break;
      if (Character.isUpperCase(s[i].charAt(0)) && !visit[i - 1]) {
        num--;
        s[i - 1] += '_';
        visit[i - 1] = true;
      }
    }

    for (int i = 0; i < n; i++)
      System.out.print(s[i]);
  }
}
