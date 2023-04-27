import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    Point[] a = new Point[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      a[i] = new Point(x, y);
    }

    Arrays.sort(a);
    PriorityQueue<Integer> q = new PriorityQueue<>();
    q.add(a[0].y);
    for (int i = 1; i < n; i++) {
      if (q.peek() <= a[i].x)
        q.poll();
      q.add(a[i].y);
    }

    System.out.print(q.size());
  }

  static class Point implements Comparable<Point>{
    int x, y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point o) {
      if (this.x == o.x)
        return this.y - o.y;
      return this.x - o.x;
    }
  }
}
