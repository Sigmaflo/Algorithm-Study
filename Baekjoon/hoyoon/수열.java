import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] days = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        int start = 0;
        int end = 0;
        while (end < K) {
            sum += days[end++];
        }

        int max = sum;
        while (end < N) {
            sum += days[end++] - days[start++];
            max = Math.max(max, sum);
        }

        System.out.println(max);
        br.close();
    }
}
