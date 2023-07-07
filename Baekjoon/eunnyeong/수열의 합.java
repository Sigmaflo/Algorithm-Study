import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());

    int min = Integer.MAX_VALUE, sum = 0, x = 0, start = 0, end = 0;

    for (int i = 0; i <= n; i++) {
      sum += i;
      while (sum > n) {
        sum -=x;
        x++;
      }

      if (sum == n && i - x + 1 >= l) {
        if (min > i - x + 1) {
          start = x;
          end = i;
          min = i - start + 1;
        }
        if (i - x + 1 == 1) break;
      }
    }

    if (sum - start == n && (end - start + 1) > l) start++;

    if (end - start + 1 > 100 || min == Integer.MAX_VALUE)
      System.out.println(-1);
    else {
      for (int i = start; i <= end; i++)
        System.out.print(i + " ");
    }
  }
}
