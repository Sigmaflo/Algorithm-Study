import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  static int k, ans = Integer.MAX_VALUE;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    bfs(n);

    System.out.print(ans);
  }

  public static void bfs(int n) {
    Queue<Point> q = new ArrayDeque<>();
    boolean[] visit = new boolean[100001];
    q.add(new Point(n, 0));
    visit[n] = true;

    while (!q.isEmpty()) {
      Point p = q.poll();
      if (p.x == k) {
        ans = p.y;
        break;
      }
      if (p.x + 1 <= 100000 && !visit[p.x + 1]) {
        visit[p.x + 1] = true;
        q.add(new Point(p.x + 1, p.y + 1));
      }
      if (p.x - 1 >= 0 && !visit[p.x - 1]) {
        visit[p.x - 1] = true;
        q.add(new Point(p.x - 1, p.y + 1));
      }
      if (p.x * 2 <= 100000 && !visit[p.x * 2]) {
        visit[p.x * 2] = true;
        q.add(new Point(p.x * 2, p.y + 1));
      }
    }
  }
}
