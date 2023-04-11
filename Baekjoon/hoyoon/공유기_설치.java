import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기_설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] houses = new int[N];
        int min = 0;
        int max = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
            if (houses[i] > max) max = houses[i];
        }
        Arrays.sort(houses);

        while (min <= max) {
            int mid = (min + max) / 2;
            int cnt = 1;
            int start = houses[0];
            for (int i = 1; i < N; i++) {
                if (houses[i] - start >= mid) {
                    cnt++;
                    start = houses[i];
                }
            }

            if (cnt < C) {
                max = mid - 1;
            }
            else {
                min = mid + 1;
                if (cnt == C) answer = Math.max(answer, mid);
            }
        }

        System.out.println(max);
        br.close();
    }
}
