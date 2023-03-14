package Baekjoon.seungah;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class 문자열지옥에빠진호석 {
    static int N, M, K;
    static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] dy = {1, 0, -1, 1, 0, -1, 1, -1};
    static int MAX_LENGTH;

    static HashMap<String, Integer> favString = new HashMap<>();
    static char[][] hell;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());

        // output 때 사용할 key array
        String[] ansKey = new String[K];
        hell = new char[N][M];
        // 입력 받기
        for (int i=0; i<N; i++) {
            hell[i] = br.readLine().toCharArray();
        }

        for (int i=0; i<K; i++) {
            String favstr = br.readLine();
            MAX_LENGTH = Math.max(MAX_LENGTH, favstr.length());
            ansKey[i] = favstr;
            favString.put(favstr, 0); // value: count
        }

        for (int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                DFS(i, j, 1, Character.toString(hell[i][j]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String key: ansKey){
            sb.append(favString.get(key)).append("\n");
        }

        System.out.println(sb);
        
    }

    public static void DFS(int x, int y, int depth, String result){
        if(favString.containsKey(result)) { // 키값과 같은게 존재하면 value +1
            favString.put(result, favString.get(result) + 1);
        }

        if(depth == MAX_LENGTH) {
            return;
        }

        for(int dir=0;dir<dx.length; dir++){
            int nx = dx[dir]+x;
            int ny = dy[dir]+y;

            if(nx<0) {
                nx = N-1;
            }
            else if(nx >= N) {
                nx = 0;
            }

            if (ny<0) {
                ny = M-1;
            }
            else if(ny >= M) {
                ny = 0;
            }

            DFS(nx, ny, depth+1, result+hell[nx][ny]);
        }
    }
}
