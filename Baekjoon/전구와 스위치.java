import java.io.*;
import java.util.*;

public class Main {

  static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    String ans = br.readLine();

    int cnt = 0;
    while(true) {
      int x = check(s, ans);
      if (x == -1) break;
      if (x != -1)
        s = change(s, x);
      x = check(s, ans);
      cnt++;
      if (x == -1) break;
    }

    System.out.print(cnt);
  }

  public static int check(String a, String b) {
    for (int i = 0; i < n; i++) {
      if (a.charAt(i) != b.charAt(i))
        return i;
    }
    return -1;
  }
  public static String change(String s, int idx) {
    char[] tmp = s.toCharArray();
    if (idx - 1 >= 0)
      tmp[idx - 1] = tmp[idx - 1] == '0' ? '1' : '0';
    if (idx + 1 < n)
      tmp[idx + 1] = tmp[idx + 1] == '0' ? '1' : '0';

    tmp[idx] = tmp[idx] == '0' ? '1' : '0';

    return new String(tmp);
  }
}
