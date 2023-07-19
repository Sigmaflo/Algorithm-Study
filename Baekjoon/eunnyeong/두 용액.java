import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());

    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

   Arrays.sort(a);

   int s = 0, e = n - 1, x = a[s], y = a[e], sum = a[s] + a[e];
   while (true) {
     int tmp = a[s] + a[e];
     if (Math.abs(sum - 0) > Math.abs(tmp - 0)) {
       sum = tmp;
       x = a[s];
       y = a[e];
     }

     if (tmp == 0) {
       x = a[s];
       y = a[e];
       break;
     }
     if (tmp > 0)
       e--;
     if (tmp < 0)
       s++;

     if (s == e) break;
   }

   System.out.print(x + " " + y);
  }
}
