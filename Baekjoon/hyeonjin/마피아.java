import java.io.*;
import java.util.*;

public class 마피아 {
    static int N;
    static int[] index;
    static int[][] arr;
    static int me;
    static boolean[] die;
    static int night = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        N = Integer.valueOf(br.readLine());
        die = new boolean[N];
        index = new int[N];
        arr = new int[N][N];

        //index
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            index[i] = Integer.valueOf(str.nextToken());
        }

        //arr
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.valueOf(str.nextToken());
            }
        }

        me = Integer.valueOf(br.readLine());

        dfs(0, N, 0);
        System.out.println(night);
    }

    private static void dfs(int depth, int empty, int nightCount) {
        if(die[me] || depth == N - 1){
            night = Math.max(nightCount, night);
            return;
        }

        //밤
        if(empty % 2 == 0) dieNight(depth, empty, nightCount);
        else dieDaytime(depth, empty, nightCount);
    }

    private static void dieNight(int depth, int empty, int nightCount) {

        for(int i = 0; i < N; i++){
            if(die[i] || i == me) continue;

            die[i] = true;
            addIndex(i);
            dfs(depth + 1, empty - 1, nightCount + 1);
            minusIndex(i);
            die[i] = false;
        }
    }

    private static void dieDaytime(int depth, int empty, int nightCount) {
        int dieIndex = -1;
        int max = -1;
        for(int i = 0; i < N; i++){
            if(die[i]) continue;

            if(max < index[i]){
                max = index[i];
                dieIndex = i;
            }
        }

        die[dieIndex] = true;
        dfs(depth + 1, empty - 1, nightCount);
        die[dieIndex] = false;
    }

    private static void addIndex(int target) {
        for(int i = 0; i < N; i++){
            if(target == i) continue;

            index[i] += arr[target][i];
        }
    }

    private static void minusIndex(int target) {
        for(int i = 0; i < N; i++){
            if(target == i) continue;

            index[i] -= arr[target][i];
        }
    }
}
