import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 마피아 {
    private static int N;
    private static int[] guiltyIndex;
    private static boolean[] dead;
    private static int[][] R;
    private static int mafia;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        guiltyIndex = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        dead = new boolean[N];
        R = new int[N][N];

        for (int i = 0; i < N; i++) {
            R[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        mafia = Integer.parseInt(br.readLine());

        int answer = getMaxTurn(N);

        System.out.println(answer);
        br.close();
    }

    private static int getMaxTurn(final int left) {
        int maxRound = 0;
        int deadCnt = 1;
        int people = -1;

        if (left % 2 == 1) {
            deadCnt++;
            int maxGuilty = 0;
            for (int i = 0; i < N; i++) {
                if (!dead[i] && maxGuilty < guiltyIndex[i]) {
                    maxGuilty = guiltyIndex[i];
                    people = i;
                }
            }
            if (people == mafia) return maxRound;
            dead[people] = true;
        }

        for (int i = 0; i < N; i++) {
            if (dead[i] || i == mafia) continue;
            dead[i] = true;
            for (int j = 0; j < N; j++)
                guiltyIndex[j] += R[i][j];
            maxRound = Math.max(maxRound, getMaxTurn(left - deadCnt));
            dead[i] = false;
            for (int j = 0; j < N; j++)
                guiltyIndex[j] -= R[i][j];
        }

        if (people != -1) dead[people] = false;
        return maxRound + 1;
    }
}