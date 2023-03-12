import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

  static int n, ans = 0, cnt = 0;
  static ArrayList[] a;
  static int[] check = new int[26];
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    a = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      a[i] = new ArrayList<Integer>();
      HashSet<Integer> h = new HashSet<>();
      for (int j = 0; j < s.length(); j++) {
        int x = s.charAt(j) - 'a';
        if (!h.contains(x)) {
          h.add(x);
          a[i].add(x);
        }
      }
    }

    calc(0, 0);

    System.out.print(ans);
  }

  public static void calc(int idx, int f) {
    if (cnt == 26) {
      ans += 1<<(n-idx);
      return;
    }
    if (idx == n) return;

    for (int i = 0; i < a[idx].size(); i++) {
      int x = (int)a[idx].get(i);
      check[x]++;
      if (check[x] == 1)
        cnt++;
    }
    calc(idx +  1, f);

    for (int i = 0; i < a[idx].size(); i++) {
      int x = (int)a[idx].get(i);
      check[x]--;
      if (check[x] == 0)
        cnt--;
    }
    calc(idx +  1, f);
  }
}
