
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2458 {
	static int N;
	static int[][] mat;
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
	private static void pro() {
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(mat[i][j]==0 || mat[i][k]==0 || mat[k][j]==0)
						continue;
					if(mat[i][j] > mat[i][k] + mat[k][j]) {
						mat[i][j] = mat[i][k] + mat[k][j];
						mat[j][i] = 0;
					}
				}
			}
		}
	
		int count = 0;
		for(int i=1; i<=N; i++) {
			boolean check = true;
			for(int j=1; j<=N; j++) {
				if(mat[i][j]==501) {
					check = false;
					break;
				}
			}
			if(check)
				count++;
		}
		System.out.println(count);
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		mat = new int[N + 1][N + 1];
		
		for(int i=1; i<=N; i++) {
			Arrays.fill(mat[i], 501);
			mat[i][i] = 0;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			mat[a][b] = 1;
			mat[b][a] = 0;
		}
		
		br.close();		
	}
}	
