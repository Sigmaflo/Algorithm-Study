package ThisWeek37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No12886 {
	static int A, B, C;

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	private static void pro() {
		if((A + B + C) %3 != 0) {
			System.out.println(0);
			return;
		}
		
		boolean [][] visit= new boolean[1501][1501];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {A, B, C});
		visit[A][B] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if(cur[0]==cur[1] && cur[1] == cur[2]) {
				System.out.println(1);
				return;
			}
			
			if(cur[0]<cur[1]) {
				int nx = cur[0] * 2;
				int ny = cur[1] - cur[1];
				
				if(!visit[nx][ny]) {
					visit[nx][ny] = true;
					queue.add(new int[] {nx, ny, cur[2]});
				}
			}
			else if(cur[0]>cur[1]) {
				int nx = cur[0] - cur[1];
				int ny = cur[1] * 2;
				
				if(!visit[nx][ny]) {
					visit[nx][ny] = true;
					queue.add(new int[] {nx, ny, cur[2]});
				}
			}
			
			if(cur[1]<cur[2]) {
				int ny = cur[1] * 2;
				int nz = cur[2] - cur[1];
				
				if(!visit[cur[0]][ny]) {
					visit[cur[0]][ny] = true;
					queue.add(new int[] {cur[0], ny, nz});
				}
			}
			else if(cur[1]>cur[2]) {
				int ny = cur[1] - cur[2];
				int nz = cur[2] * 2;
				
				if(!visit[cur[0]][ny]) {
					visit[cur[0]][ny] = true;
					queue.add(new int[] {cur[0], ny, nz});
				}
			}
			
			if(cur[0]<cur[2]) {
				int nx = cur[0] * 2;
				int nz = cur[2] - cur[0];
				
				if(!visit[nx][cur[1]]) {
					visit[nx][cur[1]] = true;
					queue.add(new int[] {nx, cur[1], nz});
				}
			}
			else if(cur[0]>cur[2]) {
				int nx = cur[0] - cur[2];
				int nz = cur[2] * 2;
				
				if(!visit[nx][cur[1]]) {
					visit[nx][cur[1]] = true;
					queue.add(new int[] {nx, cur[1], nz});
				}
			}
		}
		System.out.println(0);
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		br.close();
	}
}
