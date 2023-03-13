import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int[] a;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    a = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    Arrays.sort(a);

    long min = 0;
    int idx = Integer.MAX_VALUE;
    for (int i = n / 2; i < n; i++) {
      long sum = 0, f = 0;
      for (int j = 0; j < n; j++) {
        if (min != 0 && sum > min) {
          f = 1;
          break;
        }
        sum += Math.abs(a[j] - a[i]);
      }
      if (f == 0) {
        if (min >= sum || min == 0) {
          min = sum;
          if (idx > a[i])
            idx = a[i];
        }
        else break;
      }
    }

    for (int i = n / 2 - 1; i >= 0; i--) {
      long sum = 0, f = 0;
      for (int j = 0; j < n; j++) {
        if (min != 0 && sum > min) {
          f = 1;
          break;
        }
        sum += Math.abs(a[j] - a[i]);
      }
      if (f == 0) {
        if (min >= sum || min == 0) {
          min = sum;
          if (idx > a[i])
            idx = a[i];
        }
        else break;
      }
    }

    System.out.print(idx);
  }
}
