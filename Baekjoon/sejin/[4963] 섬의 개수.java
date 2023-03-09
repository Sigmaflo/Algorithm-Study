import java.io.*;
import java.util.*;

public class Main{

	static int W,H;
	static int[][] map ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();

		while(true){
			st  = new StringTokenizer(br.readLine());
			W = stoi(st.nextToken()); // 넓이
			H = stoi(st.nextToken()); // 높이

			if(W+H == 0 ){
				System.out.println(sb.toString());
				break;
			}
			map = new int[H][W];

			for(int i=0;i<H;i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++){
					map[i][j] = stoi(st.nextToken());
				}
			}

			sb.append(FindLand()+"\n");
		}
    }

	static int[] dx = {-1,0,1,0,-1,1,-1,1}, dy = {0,-1,0,1,-1,-1,1,1};
	static boolean[][] visited ;

	public static int FindLand(){
		int count = 0 ;


		for(int i=0;i<H;i++){
			for(int j=0;j<W;j++){
				if(map[i][j] == 1 ){
					DFS(i,j);
					count ++ ;
				}
			}
		}

		
		return count ;
	}

	public static void DFS(int x, int y){
		for(int i=0;i<8;i++){
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(xx<0 || xx>=H || yy<0 || yy>=W)continue ;
			if(map[xx][yy] == 1){
				map[xx][yy] = 0 ; // visited 대신
				DFS(xx,yy);
			}
		}
	}
}
