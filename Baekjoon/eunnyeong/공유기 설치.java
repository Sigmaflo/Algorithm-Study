import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

  static int n, c;
  static int[] a;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(br.readLine());

   int s = 0, e = n - 1;
   while (s < e) {
     int mid = (s + e) / 2;

     if (calc(mid) < c)
       e = mid;
     else
       s = mid + 1;

   }

   System.out.print(s + 1);
  }

  public static int calc(int mid) {
    int cnt = 0;
    int w = a[0];

    for (int i = 0; i < n; i++) {
      int t = a[i];

      if (t - w >= mid) {
        cnt++;
        w = t;
      }
    }

    return cnt;

  }
}
