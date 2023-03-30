import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] fee = new int[n];
    for (int i = 0; i < n; i++)
      fee[i] = Integer.parseInt(br.readLine());

    int[] car = new int[m + 1];
    for (int i = 1; i <= m; i++)
      car[i] = Integer.parseInt(br.readLine());

    int[] park = new int[n];
    Queue<Integer> q = new ArrayDeque<>();
    int sum = 0;
    for (int i = 0; i < 2 * m; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x > 0) {
        int f = 0;
        for (int j = 0; j < n; j++) {
          if (park[j] == 0) {
            park[j] = x;
            f = 1;
            break;
          }
        }
        if (f == 0)
          q.add(x);
      }
      else {
        x *= -1;
        for (int j = 0; j < n; j++) {
          if (park[j] == x) {
            park[j] = 0;
            sum += fee[j] * car[x];
            if (!q.isEmpty())
              park[j] = q.poll();
            break;
          }
        }
      }
    }

    System.out.print(sum);
  }
}
