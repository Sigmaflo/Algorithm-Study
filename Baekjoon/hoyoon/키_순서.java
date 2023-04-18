import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 키_순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] hasRecord = new boolean[N + 1][N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            hasRecord[a][b] = true;
        }

        for (int m = 1; m <= N; m++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (hasRecord[i][m] && hasRecord[m][j])
                        hasRecord[i][j] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (hasRecord[i][j] || hasRecord[j][i])
                    cnt++;
            }
            if (cnt == N - 1)
                answer++;
        }

        System.out.println(answer);
        br.close();
    }
}
