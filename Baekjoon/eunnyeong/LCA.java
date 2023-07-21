import java.io.*;
import java.util.*;

public class Main {

  static List[] list;
  static int n;
  static boolean[] visit;
  static List<Integer> l;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    list = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++)
      list[i] = new ArrayList<Integer>();

    for (int i = 0; i < n - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      list[x].add(y);
      list[y].add(x);
    }

    int m = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int k = 0; k < m; k++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      List<Integer> a = makeList(x);
      HashSet<Integer> ha = new HashSet<>();
      ha.addAll(a);

      List<Integer> b = makeList(y);
      HashSet<Integer> hb = new HashSet<>();
      hb.addAll(b);

      x = checkIdx(hb, a);
      y = checkIdx(ha, b);

      int min = n;
      for (int i = 0; i < a.size(); i++)
        if (a.get(i) == x || (a.get(i) == y))
          min = Math.min(min, i);

      sb.append(a.get(min) + "\n");
    }

    bw.write(sb.toString());
    bw.flush(); bw.close(); br.close();
  }

  public static int checkIdx(HashSet<Integer> h, List<Integer> a) {
    int x = 0;
    for (int i = 0; i < a.size(); i++) {
      if (h.contains(a.get(i))) {
        x = a.get(i);
        break;
      }
    }
    return x;
  }

  public static List<Integer> makeList(int x) {
    visit = new boolean[n + 1];
    l = new ArrayList<>();

    l.add(x);
    dfs(x);

    List<Integer> t =  new ArrayList<>(l);
    int idx = t.indexOf(1);
    t.subList(idx + 1, t.size()).clear();
    return t;
  }

  public static void dfs(int x) {
    if (visit[x]) return;
    visit[x] = true;

    for (int i = 0; i < list[x].size(); i++) {
      int t = (Integer) list[x].get(i);
      if (!visit[t]) {
        l.add(t);
        if (t == 1) return;
        dfs(t);
      }
    }
  }
}
