import java.io.*;
import java.util.*;

public class Main {

  static int x, ans = -1;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    x = Integer.parseInt(br.readLine());
    calc(0, 0);

    System.out.println(ans);

  }

  public static void calc(int n, int cnt) {
    if (cnt == x) {
      ans = n;
      return;
    }

    String s = Integer.toString(n);
    int f = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) <= s.charAt(i + 1)) {
        f = 1;
        break;
      }
    }

    if (f == 1)
      calc(n + 1, cnt);
    else
      calc(n + 1, cnt + 1);
  }
}
