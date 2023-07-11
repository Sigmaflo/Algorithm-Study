import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  static int n, m;
  static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1}, dy = {0, -1, -1, 0, 1, 1, 1, 0, -1}; //←, ↖, ↑, ↗, →, ↘, ↓, ↙
  static int[][] map, cloud;
  static Point[] order;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++)
        map[i][j] = Integer.parseInt(st.nextToken());
    }

    order = new Point[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      order[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    cloud = new int[n + 1][n + 1];
    cloud[n][1] = cloud[n][2] = cloud[n - 1][1] = cloud[n - 1][2] = 1;

    for (int i = 0; i < m; i++) {
      move(order[i].x, order[i].y);
      water();
      make();
    }

    int sum = 0;
    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= n; j++)
        sum += map[i][j];

    System.out.print(sum);
  }

  public static void make() {
    int[][] tmp = new int[n + 1][n + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (map[i][j] >= 2 && cloud[i][j] != 1) {
          tmp[i][j] = 1;
          map[i][j] -= 2;
        }
      }
    }

    copy(cloud, tmp);
  }
  
  public static void water() {
    int[][] tmp = new int[n + 1][n + 1];
    copy(tmp, map);

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (cloud[i][j] == 1) {
          int cnt = 0;
          for (int k = 2; k <= 8; k+=2) {
            int nx = i + dx[k], ny = j + dy[k];
            if (range(nx, ny) && map[nx][ny] > 0)
              cnt++;
          }
          tmp[i][j] += cnt;
        }
      }
    }
    copy(map, tmp);
  }

  public static void move(int d, int s) {
    int[][] tmp = new int[n + 1][n + 1];

     for (int i = 1; i <= n; i++) {
       for (int j = 1; j <= n; j++) {
         if (cloud[i][j] == 1) {
           int nx = i + dx[d] * s, ny = j + dy[d] * s;
           if (!range(nx, ny)) {
             nx %= n; ny %= n;
             if (nx <= 0)
               nx +=n;
             if (ny <= 0)
               ny +=n;
           }
           tmp[nx][ny] = 1;
         }
       }
     }
     copy(cloud, tmp);

      for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
          if (cloud[i][j] == 1)
            map[i][j]++;
  }

  public static boolean range (int nx, int ny) {
    if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) return true;
    return false;
  }

  public static void copy (int[][] a, int[][] b) {
    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= n; j++)
        a[i][j] = b[i][j];
  }
}
