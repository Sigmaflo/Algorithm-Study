import java.io.*;
import java.util.*;

public class Main {

  static int[] p, s, a;
  static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    p = new int[n];
    s = new int[n];

    int t = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      if (i % 3 == 0 && i != 0)
        t += 3;

      p[i] = Integer.parseInt(st.nextToken()) + t;
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      s[i] = Integer.parseInt(st.nextToken());

    int[] num = new int[n]; // 0 1 2 3 4 5 (원래 순서)
    for (int i = 0; i < n; i++)
      num[i] = i;

    a = new int[n];
    for (int i = 0; i < n; i++) {
     a[i] = num[p[i]];
    }

    int cnt = 0;
    while (true) {
      int[] tmp = a.clone();
      for (int i = 0; i < n; i++) {
        tmp[i] = a[s[i]];
      }
      cnt++;
      int f = 0;
      for (int i = 0; i < n; i++) {
        if (tmp[i] != a[i]) {
          f = 1;
          break;
        }
      }
      
      if (f == 0) break;
    }
    
    System.out.print(cnt);

  }
}
