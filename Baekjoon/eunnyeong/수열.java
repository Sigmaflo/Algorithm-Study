import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    int sum = 0;
    for (int i = 0; i < k; i++)
      sum += a[i];

    int max = sum;
    int p1 = 0, p2 = k;
    while(true) {
      sum -= a[p1++];
      sum += a[p2++];
      max = Math.max(max, sum);
      if (p1 >= n - k || p2 >= n) break;
    }

    System.out.print(max);
  }
}
