import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  static List<Integer> map[];
  static boolean[] visit;
  static int max, cnt;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    map = new List[n + 1];
    for (int i = 1; i <= n; i++)
      map[i] = new ArrayList<>();

    HashSet<Integer> s = new HashSet<>();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      map[b].add(a);
      if (!s.contains(b))
        s.add(b);
      if (!s.contains(a))
        s.add(a);
    }

    PriorityQueue<Check> q = new PriorityQueue<>();
    for (Integer i : s) {
      visit = new boolean[n + 1];
      max = -1;
      cnt = 1;
      dfs(i);
      q.add(new Check(i, max));
    }

    StringBuilder sb = new StringBuilder();
    Check c = q.poll();
    sb.append(c.x + " ");
    while(!q.isEmpty()) {
      Check t = q.poll();
      if (c.cnt == t.cnt)
        sb.append(t.x + " ");
      else
        break;
    }

    bw.write(sb.toString());
    bw.flush(); bw.close(); br.close();
  }

  public static void dfs(int x) {
    if (visit[x]) return;
    cnt++;
    max = Math.max(max, cnt);
    visit[x] = true;

    for (int i = 0; i < map[x].size(); i++) {
      int next = map[x].get(i);
      if (!visit[next])
        dfs(next);
    }
  }

  static class Check implements Comparable<Check>{
    int x, cnt;
    public Check(int x, int cnt) {
      this.x = x;
      this.cnt = cnt;
    }

    @Override
    public int compareTo(Check o) {
      if (o.cnt == this.cnt)
        return this.x - o.x;
      return o.cnt - this.cnt;
    }
  }
}
