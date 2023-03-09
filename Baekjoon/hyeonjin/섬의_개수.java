import java.io.*;
import java.util.*;

public class 섬의_개수 {
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        while(true){
            str = new StringTokenizer(br.readLine());
            int W = Integer.valueOf(str.nextToken());
            int H = Integer.valueOf(str.nextToken());
            if(W == 0 && H == 0) break;

            int[][] arr = new int[H][W];
            boolean[][] check = new boolean[H][W];
            for(int i = 0; i < H; i++){
                str = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++){
                    arr[i][j] = Integer.valueOf(str.nextToken());
                }
            }

            int cnt = 0;
            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    if(check[i][j] || arr[i][j] == 0) continue;

                    cnt++;
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i,j));
                    check[i][j] = true;

                    while(!queue.isEmpty()){
                        Point p = queue.poll();
                        for(int k = 0; k < 8; k++){
                            int x = p.x + dx[k];
                            int y = p.y + dy[k];

                            if(x < 0 || x >= H || y < 0 || y >= W || check[x][y] || arr[x][y] == 0) continue;

                            queue.add(new Point(x,y));
                            check[x][y] = true;
                        }
                    }
                }
            }
            bw.write(String.valueOf(cnt));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
