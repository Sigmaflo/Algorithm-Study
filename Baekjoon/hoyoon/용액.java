import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] solutions = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int neg = 0;
        int pos = N - 1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (neg < pos) {
            int res = solutions[pos] + solutions[neg];

            if (Math.abs(res) < min) {
                min = Math.abs(res);
                answer = new int[]{solutions[neg], solutions[pos]};
            }

            if (res == 0) break;
            else if (res > 0) pos--;
            else neg++;
        }

        System.out.printf("%d %d\n", answer[0], answer[1]);
        br.close();
    }
}
