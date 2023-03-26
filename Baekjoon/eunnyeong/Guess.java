import java.io.*;
import java.util.*;

public class Main {
  static int n, f = 0;
  static char[][] c;
  static int[] num, a = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    c = new char[n][n];
    int idx = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++)
        c[i][j] = s.charAt(idx++);
    }

    num = new int[n];
    perm(0);
  }

  public static void perm (int cnt) {
    if (f == 1) return;
    if (cnt == n) {
      int[][] t = new int[n][n];
      for (int i = 0; i < n; i++) {
        t[i][i] = num[i];
        if (!(t[i][i] > 0 && c[i][i] == '+') && !(t[i][i] < 0 && c[i][i] == '-') && !(t[i][i] == 0 && c[i][i] == '0'))
          return;
      }
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          t[i][j] += t[i][j - 1] + num[j];
          if (!(t[i][j] > 0 && c[i][j] == '+') && !(t[i][j] < 0 && c[i][j] == '-') && !(t[i][j] == 0 && c[i][j] == '0'))
            return;
        }
      }
      for (int i = 0; i < n; i++)
        System.out.print(num[i] + " ");
      f = 1;
      return;
    }

    for (int i = 0; i <= 20; i++) {
        num[cnt] = a[i];
        perm(cnt + 1);
    }
  }
}
