import java.io.*;
import java.util.*;

class Node{
	int x,y,h,cnt;
	Node(int x, int y, int h, int cnt){
		this.x = x;
		this.y = y;
		this.h = h;
		this.cnt = cnt;
	}
}

public class Main {

	static int N,M,arr[][],dp[][];
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		visited = new boolean[N][M];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1 ;
			}
		}
		
		System.out.print(DFS(dp,0,0));
	}

	static int[] dx = {-1,0,1,0},dy={0,-1,0,1};
	static int ans = 0 ;

	public static int DFS(int[][] dp, int x, int y){
		if(x==N-1 && y==M-1){
			return 1 ;
		}
		if(dp[x][y] == -1 ){
			dp[x][y] = 0 ;
			for(int i=0;i<4;i++){
				int xx = x+dx[i];
				int yy = y+dy[i];
				if(xx<0 || xx>=N || yy<0 || yy>=M || visited[xx][yy]) continue;
				if(arr[xx][yy] < arr[x][y]){
					dp[x][y] += DFS(dp,xx,yy);
				}
			}
		}

		return dp[x][y];
	}
}
