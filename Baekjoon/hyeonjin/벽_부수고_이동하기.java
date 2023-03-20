import java.io.*;
import java.util.*;

public class 벽_부수고_이동하기 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());

        int[][] arr = new int[N][M];
        int[][] visit = new int[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.valueOf(s.charAt(j) - '0');
                visit[i][j]  = Integer.MAX_VALUE;
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0, 1, 0));
        visit[0][0] = 0;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            if(p.x == N - 1 && p.y == M - 1){
                System.out.println(p.dist);
                return;
            }

            for(int k = 0; k < 4; k++){
                int xx = p.x + dx[k];
                int yy = p.y + dy[k];

                if(xx < 0 || xx >= N || yy < 0 || yy >= M || visit[xx][yy] <= p.cnt) continue;


                if(arr[xx][yy] == 0){
                    visit[xx][yy] = p.cnt;
                    queue.add(new Point(xx, yy, p.dist + 1, p.cnt));
                }
                else if(p.cnt == 0){
                    visit[xx][yy] = p.cnt + 1;
                    queue.add(new Point(xx, yy, p.dist + 1, p.cnt + 1));
                }
            }
        }

        System.out.println("-1");
    }

    static class Point{
        int x;
        int y;
        int dist;
        int cnt;
        public Point(int x, int y, int dist, int cnt){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.cnt = cnt;
        }
    }
}
