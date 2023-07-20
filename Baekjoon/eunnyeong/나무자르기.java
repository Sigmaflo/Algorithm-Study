import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

   Arrays.sort(a);

   int low = 0, high = a[n - 1];
   while (low < high) {
     int mid = (low + high) / 2;
     long sum = 0;

     for (int i = n - 1; i >= 0; i--) {
       if (a[i] > mid)
         sum += a[i] - mid;
       else break;
     }

     if (sum < m)
       high = mid;
     else
       low = mid + 1;
   }

   System.out.print(low - 1);
  }
}
