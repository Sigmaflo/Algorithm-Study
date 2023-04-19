import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, max, maxH;
	static int[][] mat;
	static boolean[][] visit;

	static int[] dirx = {-1, 0, 1, 0};
	static int[] diry = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		max = 1;
		for(int i=1; i<maxH; i++) {
			check(i);
		}
		System.out.println(max);
	}
	private static void check(int height) {
		int cnt = 0;
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j] || mat[i][j] <= height)
					continue;
				cnt++;
				dfs(i, j, height);
			}
		}
//		System.out.println(height + " " + cnt);
		max = Math.max(cnt, max);
	}
	// 깊이 우선 탐색으로 방문하기
	private static void dfs(int i, int j, int height) {
		if(visit[i][j])
			return;
		visit[i][j] = true;
		
		for(int di = 0; di<4; di++) {
			int nx = i + dirx[di];
			int ny = j + diry[di];
			
			if(nx<0||ny<0||nx>=N||ny>=N)
				continue;
			if(visit[nx][ny] || mat[nx][ny] <= height)
				continue;
			dfs(nx, ny, height);
		}
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		mat = new int[N][N];
		maxH = 1;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, mat[i][j]);
			}
		}
		br.close();
	}
}
