import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 0; i < results.length; i++)
            arr[results[i][0]][results[i][1]] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    if (arr[j][i] == 1 && arr[i][k] == 1)
                        arr[j][k] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int game = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1 || arr[j][i] == 1) game++;
            }
            if (game == n - 1) answer++;
        }
        return answer;
    }
}