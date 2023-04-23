import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ans;
    static int[][] map;
    static int[] dx= {1,0,-1,0}, dy= {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < m; j++)
        		map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        wall(0);
        
        System.out.println(ans);
       
    }
    
    public static void wall(int cnt) { //벽을 세우는 함수
    	if (cnt == 3) { //벽이 세 개 일때 바이러스를 퍼트려준다
    		bfs();
    		return;
    	}
    	
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < m; j++) {
    			if (map[i][j] == 0) { //빈칸일 때 백트래킹으로 경우의 수 구현
    				map[i][j] = 1;
    				wall(cnt + 1);
    				map[i][j] = 0;
    			}
    		}
    	}
    }
    
    public static void bfs() { //바이러스를 퍼트리는 함수
    	Queue<Point> q = new LinkedList<>();
   	
    	for (int i = 0; i < n; i++)
    		for (int j = 0; j < m; j++)
    			if (map[i][j] == 2)  //바이러스일때
    				q.add(new Point(i, j));
    	
    	int tmp[][] = new int[n][m];
    	
    	for (int i = 0; i < n; i++)
    		for (int j = 0; j < m; j++)
    			tmp[i][j] = map[i][j]; //원본 배열 값 유지 위해 복사
    	
    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		for (int k = 0; k < 4; k++) {
    			int nx = p.x + dx[k], ny = p.y + dy[k];
    			if (nx >= 0 && nx < n && ny >=0 && ny < m && tmp[nx][ny] == 0) {
    				tmp[nx][ny] = 2; //빈칸이면 상하좌우로 바이러스 확산
    				q.add(new Point(nx, ny));
    			}
    		}
    	}
    	
    	int cnt = 0; //안전 영역 크기
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < m; j++) 
    			if (tmp[i][j] == 0)
    				cnt++;
    	}
    	
    	ans = Math.max(cnt, ans); //벽이 세워지는 경우마다 최대의 안전 영역 크기 구하기
    }
}
