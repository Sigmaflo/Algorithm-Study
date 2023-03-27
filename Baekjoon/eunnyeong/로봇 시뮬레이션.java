import java.io.*;
import java.util.*;

public class Main {
    
  static int a, b, n, m;
  static int[][] map;
  static Robot[] r;
  static Order[] o;
  static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1}; //N, E, S, W
    
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    map = new int[a + 1][b + 1];
    r = new Robot[n + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      char c = st.nextToken().charAt(0);
      int d = 0;
      if (c == 'E') d = 1;
      if (c == 'S') d = 2;
      if (c == 'W') d = 3;
      r[i] = new Robot(x, y, d);
      map[x][y] = 1;
    }

    o =  new Order[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int idx = Integer.parseInt(st.nextToken());
      char c = st.nextToken().charAt(0);
      int num = Integer.parseInt(st.nextToken());
      o[i] = new Order(idx, c, num);
    }

    for (int i = 0; i < m; i++) {
      int idx = o[i].idx;
      if (o[i].o == 'F') {
        for (int j = 1; j <= o[i].num; j++) {
          int nx = r[idx].x + j * dx[r[idx].d], ny = r[idx].y + j * dy[r[idx].d];
          if (range(nx, ny)) {
            if (map[nx][ny] != 0) {
              System.out.print("Robot " + idx + " crashes into robot " + map[nx][ny]);
              System.exit(0);
            }
            map[r[idx].x][r[idx].y] = 0;
            map[nx][ny] = idx;
            r[idx] = new Robot(nx, ny, r[idx].d);
          }
          else {
            System.out.print("Robot " +  idx + " crashes into the wall");
            System.exit(0);
          }
        }
      }
      else {
        int x = o[i].num % 4;
        if (o[i].o == 'L')
          r[idx] = new Robot(r[idx].x, r[idx].y, Math.abs(r[idx].d - x));
        if (o[i].o == 'R')
          r[idx] = new Robot(r[idx].x, r[idx].y, (r[idx].d + x) % 4);
      }
    }

    System.out.print("OK");
  }

  public static boolean range(int nx, int ny) {
    if (nx >= 1 && nx <= a && ny >= 1 && ny <= b) return true;
    return false;
  }


  static class Order {
    int idx, num; //로봇 번호, 명령 횟수
    char o; //명령

    public Order(int idx, char o, int num) {
      this.idx = idx;
      this.o = o;
      this.num = num;
    }
  }

  static class Robot {
    int x, y, d;

    public Robot(int x, int y, int d) {
      this.x = x;
      this.y = y;
      this.d = d;
    }
  }
}
