package ThisWeek37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No20922 {
	static int N, K;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		int[] cnt = new int[100_001];
		
		int idx = 0;
		int max = 0;
		for(int i=0; i<N; i++) {
			cnt[arr[i]]++;
			while(cnt[arr[i]] > K) {
				cnt[arr[idx++]]--;
			}
			max = Math.max(max, i - idx + 1);
		}
		System.out.println(max);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
}
