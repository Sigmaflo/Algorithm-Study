import java.io.*;
import java.util.*;

class horseInfo{
	int idx,x,y,dist;
	horseInfo(int idx, int x, int y, int dist){
		this.idx = idx ;
		this.x = x ;
		this.y = y ;
		this.dist = dist ;
	}
}


public class Main{

	static int N,K;
	static int[][] map ;
	static ArrayList<Integer>[][] horseArr;
	static horseInfo[] horses;

	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); // 체스판의 크기
		K = stoi(st.nextToken()); // 말의 개수
		map = new int[N][N];
		horseArr = new ArrayList[N][N];
		horses = new horseInfo[K];

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) horseArr[i][j] = new ArrayList<>();
		}

		for(int i=0;i<N;i++){
			//1010
			st = new StringTokenizer(br.readLine());
			// 0 흰색, 1 빨강, 2 파랑
			for(int j=0;j<N;j++)map[i][j] = stoi(st.nextToken());
			
		}

		for(int i=0;i<K;i++){
			//  →, ←, ↑, ↓
			// x,y,번호
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken())-1;
			int y = stoi(st.nextToken())-1;
			int dist = stoi(st.nextToken())-1;
			horseArr[x][y].add(i);
			horses[i] = new horseInfo(i, x, y, dist);
		}

		System.out.println(moveHorse());
    }

	static int count = 0 ;
	static int[] dx = {0,0,-1,1},dy={1,-1,0,0};

	static final int[] change = { 1, 0, 3, 2 };

	public static int moveHorse(){
		// 이동 좌표
		boolean flag = true ;
		while(flag){
			count ++;
			if(count > 1000 ) break;

			for(int i=0;i<K;i++){
				horseInfo horseInfo = horses[i];
				int idx = horseInfo.idx;
				int x = horseInfo.x ;
				int y = horseInfo.y ;
				int dist = horseInfo.dist;

				if(horseArr[x][y].size()>0 && horseArr[x][y].get(0) != idx) continue ;// 가장 아래 아니므로 이동 불가능

				int xx = x + dx[dist];
				int yy = y + dy[dist];
	
				// 체스판을 벗어나거나, 파란색인 경우
				if(xx<0 || xx>=N || yy<0 || yy>=N || map[xx][yy] == 2){
					horses[idx].dist = change[dist];
					xx = x + dx[horses[idx].dist];
					yy = y + dy[horses[idx].dist];
				}

				if(xx<0 || xx>=N || yy<0 || yy>=N || map[xx][yy] == 2) continue;


				if(map[xx][yy] == 0 ){
					for(int j=0;j<horseArr[x][y].size()-1;j++){
						int temp = horseArr[x][y].get(j);
						horseArr[xx][yy].add(temp);
						horses[temp].x = xx ;
						horses[temp].y = yy ;

					}
					horseArr[xx][yy].addAll(horseArr[x][y]);
				}else if(map[xx][yy] == 1) {
					int size = horseArr[x][y].size()-1;

					for(int j=size;j>=0;j--){
						int temp = horseArr[x][y].get(j);
						horseArr[xx][yy].add(temp);
						horses[temp].x = xx ;
						horses[temp].y = yy ;
					}
				}

				horseArr[x][y].clear();
				if(horseArr[xx][yy].size() >= 4){
					flag = false ;
					break;
				}
			}
	}
	return flag ? -1 : count ;

	}
}
