import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    Point s = calc(st.nextToken());
    Point e = calc(st.nextToken());
    Point q = calc(st.nextToken());

    HashMap<String,Integer> h = new HashMap<>();
    int cnt = 0;
    String t;
    while((t = br.readLine()) != null) {
      st = new StringTokenizer(t);
      if (!st.hasMoreTokens()) break;
      Point time = calc(st.nextToken());
      String nick = st.nextToken();

      if ((time.x == s.x && time.y <= s.y) || (time.x < s.x))
        h.put(nick, 0);

      if (((time.x > e.x) || (time.x == e.x && time.y >= e.y)) && ((time.x < q.x) || (time.x == q.x && time.y <= q.y))) {
        if (h.containsKey(nick)) {
          if (h.get(nick) == 0) {
            cnt++;
            h.replace(nick, h.get(nick) + 1);
          }
        }
      }
    }

    System.out.print(cnt);
  }

  public static Point calc(String t) {
    int x = Integer.parseInt(t.substring(0, 2)), y = Integer.parseInt(t.substring(3, 5));
    return new Point(x, y);
  }
}
