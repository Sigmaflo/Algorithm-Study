import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 안전_영역 {
    private static final int[] UD = {-1, 1, 0, 0};
    private static final int[] LR = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int height = 0;
        int cnt = 1;
        int answer = 1;
        while (cnt > 0) {
            height++;
            boolean[][] visit = new boolean[N][N];
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= height || visit[i][j]) continue;
                    cnt++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visit[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] coordi = q.poll();

                        for (int m = 0; m < 4; m++) {
                            int nr = coordi[0] + UD[m];
                            int nc = coordi[1] + LR[m];
                            if (nr < 0 || N <= nr || nc < 0 || N <= nc
                                    || map[nr][nc] <= height || visit[nr][nc]) continue;
                            visit[nr][nc] = true;
                            q.offer(new int[]{nr, nc});
                        }
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
        br.close();
    }
}
