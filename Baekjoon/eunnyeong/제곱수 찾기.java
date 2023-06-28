import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  static int n, m, ans;
  static HashMap<Integer, Point> h;
  static int[][] map;
  static int[] select;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n + 1][m + 1];
    ans = -1;
    for (int i = 1; i <= n; i++) {
      String s = br.readLine();
      for (int j = 1; j <= m; j++) {
        map[i][j] = s.charAt(j - 1) - '0';
        if (map[i][j] == 0 || map[i][j] == 4 || map[i][j] == 9)
          ans = Math.max(ans, map[i][j]);
      }
    }

    h = new HashMap<>();
    int idx = 1;
    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= m; j++)
        h.put(idx++, new Point(i, j));

    int x = n > m ? n : m;
    for (int i = x; i >= 2; i--) {
      select = new int[i];
      comb(0, i);
    }

    System.out.print(ans);
  }

  public static boolean check(int num) {
    int x = 2;
    while(true) {
      int t = (int)Math.pow(x, 2);
      if (t < num)
        x++;
      else if (t == num)
        return true;
      else break;
    }
    return false;
  }


  public static void comb(int cnt, int d) {
    if (cnt == d) {
      Point x = h.get(select[1]);
      Point y = h.get(select[0]);
      int t = map[x.x][x.y] - map[y.x][y.y];
      int f = 0;
      String s = String.valueOf(map[y.x][y.y]);
      s += String.valueOf(map[x.x][x.y]);
      for (int i = 1; i < d - 1; i++) {
        x = h.get(select[i + 1]);
        y = h.get(select[i]);
        s += String.valueOf(map[y.x][y.y]);
        s += String.valueOf(map[x.x][x.y]);
        if (t != map[x.x][x.y] - map[y.x][y.y]) {
          f = 1;
          break;
        }
      }

      if (f == 0) {
        int num = Integer.parseInt(s);
        if (check(num))
          ans = Math.max(ans, num);
        return;
      }
      return;
    }

    for (int i = 1; i <= n * m; i++) {
      select[cnt] = i;
      comb(cnt + 1,  d);
    }
  }
}
