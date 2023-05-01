import java.io.*;
import java.util.*;

public class Main {

  static char[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s = br.readLine();
    int odd = 0, even = 0;
    char[] c = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') odd++;
      else even++;
    }

    odd /= 2;
    even /= 2;

    for (int i = 0; i < c.length; i++) {
      if (c[i] == '1' && odd > 0) {
        c[i] = '2';
        odd--;
      }
      if (odd == 0) break;
    }

    for (int i = c.length - 1; i >= 0; i--) {
      if (c[i] == '0' && even > 0) {
        c[i] = '2';
        even--;
      }
      if (even == 0) break;
    }

    String ans = "";
    for (int i = 0; i < c.length; i++)
      if (c[i] != '2')
        ans += c[i];

    System.out.print(ans);
  }
}
