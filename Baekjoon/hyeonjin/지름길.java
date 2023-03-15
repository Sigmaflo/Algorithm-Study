import java.io.*;
import java.util.*;

public class 지름길 {
    static final int MAX = 10_000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int D = Integer.valueOf(str.nextToken());

        int[] distance = new int[D + 1];
        ArrayList<Load>[] path = new ArrayList[MAX + 1];

        for(int i = 1; i <= D; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < path.length; i++){
            path[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(str.nextToken());
            int e = Integer.valueOf(str.nextToken());
            int dist = Integer.valueOf(str.nextToken());

            if(e - s > dist) path[e].add(new Load(s, dist));
        }

        for(int i = 1; i <= D; i++){
            if(path[i].size() == 0) {
                distance[i] = distance[i - 1] + 1;
                continue;
            }

            for(Load l : path[i]){
                if(distance[l.start] + l.dist > distance[i]) continue;

                distance[i] = Math.min(distance[i - 1] + 1, distance[l.start] + l.dist);
            }
        }

        System.out.println(distance[D]);
    }

    public static class Load{
        int start;
        int dist;

        public Load(int start, int dist){
            this.start = start;
            this.dist = dist;
        }
    }
}
