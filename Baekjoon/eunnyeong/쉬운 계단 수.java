import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    int[][] dp = new int[n + 1][10];

    for (int i = 1; i <= 9; i++)
      dp[1][i] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j <= 9; j++) {
        if (j == 0) dp[i][j] = dp[i - 1][1];
        else if (j == 9) dp[i][j] = dp[i - 1][8];
        else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];

        dp[i][j] %= 1000000000;
      }
    }

    long ans = 0;
    for (int i = 0; i <= 9; i++)
      ans += dp[n][i];

    System.out.print(ans);
  }
}
