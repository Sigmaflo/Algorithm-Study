import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int n = s.length();
    int[] dp = new int[n + 1];
    int[] a = new int[n + 1];

    for (int i = 0; i < n; i++)
      a[i + 1] = s.charAt(i) - '0';


    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      if (a[i] != 0)
        dp[i] = (dp[i - 1] + dp[i]) % 1000000;

      int x = a[i] + a[i - 1] * 10;

      if (10 <= x && x <= 26)
        dp[i] = (dp[i - 2] + dp[i]) % 1000000;
    }

    System.out.print(dp[n]);
  }
}
