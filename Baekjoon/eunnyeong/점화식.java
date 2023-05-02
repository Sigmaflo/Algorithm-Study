import java.io.*;
import java.math.BigInteger;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    BigInteger[] dp = new BigInteger[n + 1];
    dp[0] = BigInteger.ONE;
    
    for (int i = 1; i <= n; i++) {
      int idx = i - 1;
      dp[i] = BigInteger.ZERO;

      for (int j = 0; j < i / 2; j++)
        dp[i] = dp[i].add(dp[j].multiply(dp[idx--]));

      dp[i] = dp[i].multiply(BigInteger.valueOf(2));

      if (i % 2 != 0)
        dp[i] = dp[i].add(dp[i / 2].multiply(dp[i / 2]));
    }

    System.out.print(dp[n]);
  }
}
