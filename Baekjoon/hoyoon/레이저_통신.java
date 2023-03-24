import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 레이저_통신 {
    private static final int[] UD = {-1, 1, 0, 0};
    private static final int[] LR = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        String[][] map = new String[H][W];
        int[][][] visit = new int[H][W][4];

        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().split("");
            for (int j = 0; j < W; j++) {
                Arrays.fill(visit[i][j], 10001);
            }
        }

        int startR = 0;
        int startC = 0;
        LOOP:
        for (; startR < H; startR++) {
            for (startC = 0; startC < W; startC++) {
                if (map[startR][startC].equals("C")) break LOOP;
            }
        }

        int answer = 10001;
        Queue<Progression> queue = new LinkedList<>();
        queue.offer(new Progression(startR, startC, -1, -1));
        for (int i = 0; i < 4; i++)
            visit[startR][startC][i] = 0;

        while (!queue.isEmpty()) {
            Progression progression = queue.poll();

            for (int m = 0; m < 4; m++) {
                int nr = progression.r + UD[m];
                int nc = progression.c + LR[m];
                if (nr < 0 || H <= nr || nc < 0 || W <= nc
                        || visit[nr][nc][m] <= progression.changeDirection
                        || map[nr][nc].equals("*")) continue;

                int directionCnt = progression.changeDirection + (progression.direction == m? 0 : 1);
                if (map[nr][nc].equals("C")) {
                    answer = Math.min(answer, directionCnt);
                } else {
                    visit[nr][nc][m] = directionCnt;
                    queue.offer(new Progression(nr, nc, m, directionCnt));
                }
            }
        }

        System.out.println(answer);
        br.close();
    }

    static class Progression {
        int r;
        int c;
        int direction;
        int changeDirection;

        public Progression(int r, int c, int direction, int changeDirection) {
            this.r = r;
            this.c = c;
            this.direction = direction;
            this.changeDirection = changeDirection;
        }
    }
}
