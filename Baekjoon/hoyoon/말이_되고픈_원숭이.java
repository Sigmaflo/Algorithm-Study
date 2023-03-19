import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Move {
    int leftHorseMoving;
    int r;
    int c;

    public Move(int leftHorseMoving, int r, int c) {
        this.leftHorseMoving = leftHorseMoving;
        this.r = r;
        this.c = c;
    }
}

public class 말이_되고픈_원숭이 {
    private static final int[] horseUd = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static final int[] horseLr = {-2, -1, 1, 2, -2, -1, 1, 2};
    private static final int[] monkeyUd = {-1, 1, 0, 0};
    private static final int[] monkeyLr = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        boolean[][][] visit = new boolean[H][W][K + 1];
        int[][] map = new int[H][W];

        for (int i = 0; i < H; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int cnt = 0;
        boolean foundEnd = false;
        Queue<Move> queue = new LinkedList<>();
        queue.offer(new Move(K, 0, 0));

        LOOP:
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Move move = queue.poll();
                if (move.r == H - 1 && move.c == W - 1) {
                    foundEnd = true;
                    break LOOP;
                }

                if (move.leftHorseMoving > 0) {
                    int nextLeftHorseMoving = move.leftHorseMoving - 1;
                    for (int m = 0; m < 8; m++) {
                        int nr = move.r + horseUd[m];
                        int nc = move.c + horseLr[m];

                        if (nr < 0 || H <= nr || nc < 0 || W <= nc
                                || map[nr][nc] == 1
                                || visit[nr][nc][nextLeftHorseMoving]) continue;
                        visit[nr][nc][nextLeftHorseMoving] = true;
                        queue.offer(new Move(nextLeftHorseMoving, nr, nc));
                    }
                }

                for (int m = 0; m < 4; m++) {
                    int nr = move.r + monkeyUd[m];
                    int nc = move.c + monkeyLr[m];

                    if (nr < 0 || H <= nr || nc < 0 || W <= nc
                            || map[nr][nc] == 1
                            || visit[nr][nc][move.leftHorseMoving]) continue;
                    visit[nr][nc][move.leftHorseMoving] = true;
                    queue.offer(new Move(move.leftHorseMoving, nr, nc));
                }
            }
            cnt++;
        }

        System.out.println(foundEnd? cnt : -1);
        br.close();
    }
}
