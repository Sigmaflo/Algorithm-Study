import java.io.*;
import java.util.*;

public class Main {

  static int[] a;
  static int min = Integer.MAX_VALUE, max = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String n = br.readLine();
    int cnt = count(n);

    min = Math.min(min, cnt);
    max = Math.max(max, cnt);

    rec(n);
    System.out.print(min + " " + max);
  }


  public static int count(String s) {
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      int x = s.charAt(i) - '0';
      if (x % 2 != 0)
        cnt++;
    }
    return cnt;
  }

  public static String comb(int idx, int cnt, int d, int size, String s) {
    if (cnt == d) {
      int tmp = 0, sum = 0;
      for (int i = 0; i < d; i++) {
        sum += Integer.parseInt(s.substring(tmp, a[i] + 1));
        tmp = a[i];
      }

      String t = Integer.toString(sum);
      int num = count(s);
      min = Math.min(min, num);
      max = Math.max(max, num);
      return t;
    }
    for (int i = idx; i < size; i++) {
      a[cnt] = i;
      comb(i + 1, cnt + 1, d, size, s);
    }

    return "-1";
  }

  public static String rec(String n) {
    if (n.equals("-1")) return "-2";
    if (n.length() == 1) return "1";
    if (n.length() == 2) {
      a = new int[2];
      rec(comb(0, 0, 2, n.length(), n));
    }
    if (n.length() >= 3) {
      a = new int[3];
      rec(comb(0, 0, 3, n.length(), n));
    }
    return "-1";
  }
}
