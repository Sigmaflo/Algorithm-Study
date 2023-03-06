import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String t = br.readLine();
    char[] a = t.toCharArray();
    t = br.readLine();
    char[] b = t.toCharArray();

    String ans = "";
    int[][] dp = new int[a.length + 1][b.length + 1];
    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j <= b.length; j++) {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        if (a[i - 1] == b[j - 1]) {
          dp[i][j]++;
        }
      }
    }

    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j <= b.length; j++) {
        if ((dp[i][j] != dp[i][j - 1]) && dp[i][j] != dp[i - 1][j]) {
          ans += a[i - 1];
          i++;
        }
      }
    }

    System.out.println(dp[a.length][b.length]);
    System.out.print(ans);
  }
}
