import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 호석이_두_마리_치킨 {
    private static final int MAX = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][N + 1];
        int A = 0;
        int B = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], MAX);
            map[i][i] = 0;
        }

        while (M-- > 0) {
            int[] road = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            map[road[0]][road[1]] = 1;
            map[road[1]][road[0]] = 1;
        }

        for (int m = 1; m <= N; m++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][m] + map[m][j]);
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int sum = 0;
                for (int x = 1; x <= N; x++) {
                    sum += Math.min(map[i][x], map[j][x]);
                }
                if (min > sum) {
                   min = sum;
                   A = i;
                   B = j;
                }
            }
        }

        System.out.printf("%d %d %d%n", A, B, min * 2);
        br.close();
    }
}
