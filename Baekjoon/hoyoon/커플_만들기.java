import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 커플_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] men = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int[] women = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int sum = dp[i - 1][j - 1] + Math.abs(men[i - 1] - women[j - 1]);
                if (i == j)
                    dp[i][j] = sum;
                else if (i > j)
                    dp[i][j] = Math.min(dp[i - 1][j], sum);
                else
                    dp[i][j] = Math.min(dp[i][j - 1], sum);
            }
        }

        System.out.println(dp[n][m]);
        br.close();
    }
}
