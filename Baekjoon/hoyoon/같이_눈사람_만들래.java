import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 같이_눈사람_만들래 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] H = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] diffs = new int[N - 1];

        Arrays.sort(H);
        for (int i = 0; i < N - 1; i++) {
            diffs[i] = H[i + 1] - H[i];
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 2; j < N - 1; j++) {
                answer = Math.min(answer, Math.abs(diffs[i] - diffs[j]));
            }
            if (answer == 0) break;
        }

        System.out.println(answer);
        br.close();
    }
}
