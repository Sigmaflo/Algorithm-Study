import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  static int w, h, n;
  static Point[] list;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    w = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    n = Integer.parseInt(br.readLine());
    list = new Point[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      list[i] = new Point(x, y);
    }

    st = new StringTokenizer(br.readLine());
    Point x = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

    int sum = 0;
    for (int i = 0; i < n; i++) {
      int t = list[i].x;
      if (x.x == t)
        sum += Math.abs(x.y - list[i].y);

      else if ((x.x == 1 && t == 3) || (x.x == 3 && t == 1))
        sum += list[i].y + x.y;

      else if ( (x.x == 2 && t == 3) ||  (x.x == 3 && t == 2))
       sum += h - list[i].y + x.y;

      else if ( (x.x == 4 && t == 1) ||  (x.x == 1 && t == 4))
        sum += w - x.y + list[i].y;

      else if ( (x.x == 2 && t == 4) ||  (x.x == 4 && t == 2))
        sum += w - x.y + h - list[i].y;

      else if ( (x.x == 1 && t == 2) ||  (x.x == 2 && t == 1)) {
        int t1 = x.y + h + list[i].y;
        int t2 = w - x.y + h + w - list[i].y;
        sum += Math.min(t1, t2);
      }

      else if ((x.x == 3 && t == 4) || (x.x == 4 && t == 3)) {
        int t1 = x.y + w + list[i].y;
        int t2 = h - x.y + w + h - list[i].y;
        sum += Math.min(t1, t2);
      }
    }
    System.out.print(sum);
  }
}
