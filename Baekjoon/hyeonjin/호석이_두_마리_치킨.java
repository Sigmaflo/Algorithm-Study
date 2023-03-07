import java.io.*;
import java.util.*;

public class 호석이_두_마리_치킨 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j  = 0; j < N; j++){
                if(i == j) continue;

                arr[i][j] = 1_000_001;
            }
        }

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(str.nextToken()) - 1;
            int y = Integer.valueOf(str.nextToken()) - 1;

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        //최단 시간 구하기
        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        //건물 2개 선택하기
        int result1 = -1;
        int result2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                //각각의 정점에서 선택한 건물까지의 거리
                int dist = 0;
                for(int k = 0; k < N; k++){
                    dist += Math.min(arr[i][k], arr[j][k]);
                }

                if(dist < min){
                    result1 = i;
                    result2 = j;
                    min = dist;
                }
            }
        }

        System.out.println((result1 + 1) + " " + (result2 + 1) + " " + (min * 2));
    }

}
