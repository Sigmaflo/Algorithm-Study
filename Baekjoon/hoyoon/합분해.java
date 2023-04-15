import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합분해 {
    private static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][K];

        Arrays.fill(dp[0], 1);

        for (int i = 0; i <= N; i++) dp[i][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < K; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        System.out.println(dp[N][K - 1]);
        br.close();
    }
}
