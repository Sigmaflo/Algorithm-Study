import java.io.*;
import java.util.*;

public class Main {
	
	static int N,arr[][],ans;
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		arr = new int[N][N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = Integer.MAX_VALUE ;
		visited = new boolean[N];
		visited[0] = true ;
		getCost(0,0,0,0);

		System.out.print(ans);
	}

	public static void getCost(int depth, int cost, int bef , int parent){
		if(depth == N-1){
			if(arr[bef][parent]!=0) ans = Math.min(cost+arr[bef][parent], ans);			
			return ;
		}
		for(int i=0;i<N;i++){
			if(i!=parent && i!=bef && !visited[i] && arr[bef][i] != 0 ){
				visited[i] = true ;
				getCost(depth+1, cost+arr[bef][i], i , parent);
				visited[i] = false ;
			}
		}

		return ;
	}

}
