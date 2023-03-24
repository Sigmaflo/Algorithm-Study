import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Point startPoint, endPoint;
	static int W, H;
	static int min = Integer.MAX_VALUE;
	static char[][] map;
	static int[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new char[H][W];

		for(int i = 0; i < H; i++) {
			String str = br.readLine();
			for(int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);

				if(map[i][j] == 'C') {
					if(startPoint == null)
						startPoint = new Point(i, j, -1, 0);
					else 
						endPoint = new Point(i, j, -1, 0);
				}
			}
		}

		bfs();

		System.out.println(min);
	}

	public static void bfs() {
		
	}

}

class Point {
	int x;
	int y;
	int dir; // 레이저의 현재 방향 
	int mirror; // 현재 위치까지 설치된 거울의 개수 

	Point(int x, int y, int dir, int mirror) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.mirror = mirror;
	}
}
