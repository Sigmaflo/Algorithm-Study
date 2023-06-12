import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    char[][] a = new char[n][m];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      a[i] = s.toCharArray();
    }

    char[][] w = new char[8][8];
    char c = 'W';
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        w[i][j] = c;
        c = c == 'W' ? 'B' : 'W';
      }
      c = w[i][0] == 'W' ? 'B' : 'W';
    }

    char[][] b= new char[8][8];
    c = 'B';
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        b[i][j] = c;
        c = c == 'W' ? 'B' : 'W';
      }
      c = b[i][0] == 'W' ? 'B' : 'W';
    }

    int ans = Integer.MAX_VALUE, x = 0, y = 0;
    while (true) {
      int cnt = 0;
      for (int i = 0; i < 8; i++)
        for (int j = 0; j < 8; j++)
          if (w[i][j] != a[i + x][j + y])
            cnt++;
      ans = Math.min(cnt, ans);
      if (8 + x == n && 8 + y == m) break;

      if (y + 8 == m && x + 8 < n)
        x++;
      y++;
      if (y + 8 > m && x + 8 < m)
        y = 0;
    }

    x = 0; y = 0;
    while (true) {
      int cnt = 0;
      for (int i = 0; i < 8; i++)
        for (int j = 0; j < 8; j++)
          if (b[i][j] != a[i + x][j + y])
            cnt++;
      ans = Math.min(cnt, ans);
      
      if (8 + x == n && 8 + y == m) break;
      if (y + 8 == m && x + 8 < n)
        x++;
      y++;
      if (y + 8 > m && x + 8 < m)
        y = 0;
    }

    System.out.print(ans);
  }
}
