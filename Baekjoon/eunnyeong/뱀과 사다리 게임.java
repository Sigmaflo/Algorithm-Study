import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  static int n, m, ans = Integer.MAX_VALUE;
  static int[] a;
  static Point[] snake, ladder;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    a = new int[101];
    for (int i = 1; i <= 100; i++)
      a[i] = i;

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    ladder = new Point[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      ladder[i] = new Point(x, y);
    }

    snake = new Point[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      snake[i] = new Point(x, y);
    }

    bfs();
    System.out.print(ans);
  }

  public static void bfs() {
    boolean[] visit = new boolean[101];
    Queue<Point> q = new ArrayDeque<>();
    q.add(new Point(1, 0)); // 현재 위치, cnt
    visit[1] = true;


    while (!q.isEmpty()) {
      Point p = q.poll();

      int f = 0;
      for (int i = 0; i < n; i++) {
        if (p.x == snake[i].x && !visit[snake[i].y]) {
          q.add(new Point(snake[i].y, p.y + 1));
          visit[snake[i].y] = true;
          f = 1; break;
        }
      }
      if (f == 1) continue;

      f = 0;
      for (int i = 0; i < m; i++) {
        if (p.x == ladder[i].x && !visit[ladder[i].y]) {
          q.add(new Point(ladder[i].y, p.y + 1));
          visit[ladder[i].y] = true;
          f = 1; break;
        }
      }
      if (f == 1) continue;

      if (p.x == 100) {
        ans = Math.min(p.y, ans);
      }
      if (p.x > 100) {
        continue;
      }
      for (int i = 1; i <= 6; i++) {
        if (p.x + i <= 100 && !visit[p.x + i]) {
          q.add(new Point(p.x + i, p.y + 1));
          visit[p.x + i] = true;
        }
      }
    }
  }
}
