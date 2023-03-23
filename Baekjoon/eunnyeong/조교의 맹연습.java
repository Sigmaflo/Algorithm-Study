import java.io.*;
import java.util.*;

public class Main {

  static int A, B, C, K, d = 0; //북, 동, 남 서 (0,1,2,3)
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    int[][] dp = new int[2000001][4];
    dp[0][0] = 1;

    for (int k = 0; k < K; k++) {
      for (int d = 0; d < 4; d++) {
        if (dp[k][d] > 0) {
          if (dp[k + A][(d + 3) % 4] > 0)
            dp[k + A][(d + 3) % 4] = Math.min(dp[k + A][(d + 3) % 4], dp[k][d] + 1);
          else
            dp[k + A][(d + 3) % 4] = dp[k][d] + 1;
          if (dp[k + B][(d + 1) % 4] > 0)
            dp[k + B][(d + 1) % 4] = Math.min(dp[k + B][(d + 1) % 4], dp[k][d] + 1);
          else
            dp[k + B][(d + 1) % 4] = dp[k][d] + 1;
          if (dp[k + C][(d + 2) % 4] > 0)
            dp[k + C][(d + 2) % 4] = Math.min(dp[k + C][(d + 2) % 4], dp[k][d] + 1);
          else
            dp[k + C][(d + 2) % 4] = dp[k][d] + 1;
        }
      }
    }

    System.out.print(dp[K][0] - 1);

  }
}
