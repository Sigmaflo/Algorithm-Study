import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] wins = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(wins[i], 100);
            wins[i][i] = 0;
        }

        for (int[] result : results) {
            wins[result[0] - 1][result[1] - 1] = 1;
        }

        for (int m = 0; m < n; m++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    wins[i][j] = Math.min(wins[i][j], wins[i][m] + wins[m][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (wins[i][j] < 100 || wins[j][i] < 100) cnt++;
            }
            if (cnt == n) answer++;
        }

        return answer;
    }
}

public class 순위 {
    public static void main(String[] args) {

    }
}
