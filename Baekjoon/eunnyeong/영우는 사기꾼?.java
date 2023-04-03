import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  static int n, m, k;
  static List<Integer> list[];
  static List<Integer> tmp;
  static boolean[] visit;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    list = new ArrayList[n + 1];

    for (int i = 1; i <= n; i++)
      list[i] = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      list[y].add(x);
    }

    List<Integer> map = new LinkedList<>();
    HashSet<Integer> h = new HashSet<>();

    for (int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      if (x == 1) {
        visit = new boolean[n + 1];
        tmp = new ArrayList<>();
        find(y, y);
        for (int j = 0; j < tmp.size(); j++) {
          if (!h.contains(tmp.get(j))) {
            System.out.print("Lier!");
            System.exit(0);
          }
        }
        h.add(y);
        map.add(y);
      }
      else {
        map.remove(y);
        h.remove(y);
      }
    }
    
    System.out.print("King-God-Emperor");
  }

  public static void find(int x, int c) {
    if (visit[x]) return;
    visit[x] = true;
    if (x != c)
      tmp.add(x);

    for (int i = 0; i < list[x].size(); i++) {
      int next = list[x].get(i);
      if (!visit[next]) {
        find(next, c);
      }
    }
  }
}
