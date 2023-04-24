import java.io.*;
import java.util.*;

public class Main {

  static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++)
        a[i][j] = Integer.parseInt(st.nextToken());
    }

    int[][] sum = calc(a, a);
    for (int i = 0; i < b / 2; i++)
      sum = calc(sum, a);

    if (b % 2 != 0)
      sum = calc(sum, a);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        System.out.print(sum[i][j] + " ");
      System.out.println();
    }
  }

  public static int[][] calc(int[][] a, int[][] b) {
    int[][] sum = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          sum[i][j] += a[i][k] * b[k][j];
        }
        sum[i][j] %= 1000;
      }
    }

    return sum;
  }
}
