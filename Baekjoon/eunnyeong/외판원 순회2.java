import java.util.*;
import java.io.*;

public class Main {
	
	static int n, ans = Integer.MAX_VALUE;
	static int[] order;
	static int[][] map;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n]; //방향간 비용 입력
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());	
		}
		visit = new boolean[n];
		order = new int[n];
		
		perm(0);
		
		System.out.println(ans);
	}
	
	public static void perm(int cnt) {
		if (cnt == n) { //뽑은 후 경로 계산, 이때 0인 값이 있으면 바로 return.(길이 존재하지 않으므로 갈 수 없음)
			int sum = 0;
			for (int i = 0; i < n - 1; i++) {
				if (map[order[i]][order[i + 1]] == 0)
					return;
				sum += map[order[i]][order[i + 1]];
			}
			if (map[order[n-1]][order[0]] == 0)
				return;
			sum += map[order[n - 1]][order[0]];
			ans = Math.min(ans, sum);
			return;
		}
		//여행 경로 뽑기
		for (int i = 0; i < n; i++) {
			if (visit[i]) continue;
			visit[i] = true;
			order[cnt] = i;
			perm(cnt + 1);
			visit[i] = false;
		}
	}
}
