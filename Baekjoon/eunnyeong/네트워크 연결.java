import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N + 1][N + 1];
        boolean[] visited = new boolean[N + 1];
        int[] minEdge = new int[N + 1];
        
        int m = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            input[x][y] = weight;
            input[y][x] = weight;
        }// i노드에서 j노드까지의 비용을 모두 배열에 저장
        
        Arrays.fill(minEdge, Integer.MAX_VALUE);
        
        int minVertex,min,result = 0;
        minEdge[1] = 0; // 임의의 시작점 비용 0 셋팅
        
		for(int c = 1 ; c < N + 1; c++){// 모든 정점 수만큼 반복
            min = Integer.MAX_VALUE;// 초기값으로 정수의 최대치를 주고 시작
            minVertex = 0;
            
            for(int i=1; i< N + 1; ++i) { 
            	if(!visited[i] &&  min > minEdge[i] ) {
            		min = minEdge[i];
            		minVertex = i;
            	}
            }	
            
            result += min; 
            visited[minVertex] = true; 
            
            for (int i = 1; i < N + 1; i++) { 
                if (!visited[i] && input[minVertex][i] != 0 &&  minEdge[i] > input[minVertex][i]  ) {
                	minEdge[i] = input[minVertex][i];
                }
            }
        }
        System.out.println(result);
    }
}
