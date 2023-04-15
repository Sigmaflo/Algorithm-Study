package ThisWeek37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2225 {
	static int N, K;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		dp = new int[K+1][N+1];
		
		Arrays.fill(dp[1], 1);
		
		for(int i=2; i<=K; i++) {
			for(int j=0; j<=N; j++) {
				for(int k=0; k<=j; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 1_000_000_000;
				}
			}
		}
		
		System.out.println(dp[K][N]);
		
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		br.close();
	}
}
