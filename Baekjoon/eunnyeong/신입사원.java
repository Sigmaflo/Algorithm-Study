import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int tc = 0; tc < t; tc++) {
      int n = Integer.parseInt(br.readLine());

      Point[] a = new Point[n];
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        a[i] = new Point(x, y);
      }

      int cnt = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i != j && a[i].x > a[j].x && a[i].y > a[j].y){
            cnt++;
            break;
          }
        }
      }
      sb.append(n - cnt + "\n");
    }

    bw.write(sb.toString());
    bw.flush(); bw.close(); br.close();
  }
}
