import java.io.*;
import java.util.*;

public class Main {

  static ArrayList<Edge> list;
  static int[] select;
  static Point[] a;
  static int n;
  static List<Edge>[] graph;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    a = new Point[n];
    for (int i = 0 ; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      double x = Double.parseDouble(st.nextToken());
      double y = Double.parseDouble(st.nextToken());
      a[i] = new Point(x, y);
    }

    list = new ArrayList<>();
    select = new int[2];
    comb(0,0);
    
    prim(0, n);
  }

  public static void prim(int start, int n) {
    boolean[] visit = new boolean[n + 1];

    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.offer(new Edge(start, 0));

    int total = 0;
    while(!pq.isEmpty()) {
      Edge edge = pq.poll();
      int v = edge.w;
      int cost = edge.cost;

      if(visit[v]) continue;

      visit[v] = true;
      total += cost;

      for(Edge e : graph[v]) {
        if(!visit[e.w]) {
          pq.add(e);
        }
      }
    }
    System.out.println(total);
  }

  public static void comb(int cnt, int idx) {
    if (cnt == 2) {
      Point x = a[select[0]];
      Point y = a[select[1]];
      double cost = calc(x, y);
      list.add(new Edge(x, y, cost));
      return;
    }

    for (int i = idx; i < n; i++) {
      select[cnt] = i;
      comb(cnt + 1, i + 1);
    }
  }

  public static double calc(Point a, Point b) {
    double x = Math.pow(b.x - a.x, 2);
    double y = Math.pow(b.y - a.y, 2);
    return Math.sqrt(x + y);
  }

  static class Point {
    double x, y;
    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }

  static class Edge implements Comparable<Edge>{
    Point a, b;
    double cost;

    public Edge(Point a, Point b, double cost) {
      this.a = a;
      this.b = b;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) { //오름차 순으로 정렬
      return this.cost - o.cost;
    }
  }
}
