import java.io.*;
import java.util.*;

public class Main {

  static int n, d, ans = Integer.MAX_VALUE;
  static Road[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    a = new Road[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int dist = Integer.parseInt(st.nextToken());
      a[i] = new Road(s, e, dist);
    }

    Arrays.sort(a);

    dfs(a[0], 0);

    System.out.print(ans);
  }

  public static void dfs(Road r, int idx) {
    if (r.e >= d || idx == n - 1)  {
      if (idx == n - 1)
        r.dist += a[idx].dist;
      if (r.e < d)
        r.dist += d - a[idx].dist;
      ans = Math.min(r.dist, ans);
      return;
    }

    int s = r.s, e = r.e, dist = r.dist;
    dist += a[idx].dist;

    for (int i = idx + 1; i < n; i++) {
      if (s == a[i].s && e == a[i].e) continue;
      if (e < a[i].s) {
        dist += a[i].s - e;
        s = a[i].s; e = a[i].e;
        dfs(new Road(s, e, dist), i);
      }
    }
  }

  static class Road implements Comparable<Road>{
    int s, e, dist;
    public Road(int s, int e, int dist) {
      this.s = s;
      this.e = e;
      this.dist = dist;
    }

    @Override
    public int compareTo(Road o) {
      if (this.s  == o.s) {
        if (this.e == o.e)
          return this.dist - o.dist;
        return this.e - o.e;
      }
      return this.s - o.s;
    }
  }
}
