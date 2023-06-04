import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      x = Math.min(x, Integer.parseInt(st.nextToken()));
      y = Math.min(y, Integer.parseInt(st.nextToken()));
    }

    int sum = 0, cnt = 0, f = 0;
    if ((double)x / 6 <= y) {
      while (true) {
        if ((cnt + 1)* 6 >= n) break;
        cnt++;
      }
      sum += cnt * x;
      f = 1;
    }
    else
      sum += n * y;

    if (f == 1)
      sum += Math.min((n - cnt * 6) * y, x);

    System.out.print(sum);
  }
}
