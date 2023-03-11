import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] trees = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long goal = Arrays.stream(trees).sum() - M;

        int min = 0;
        int max = (int) Arrays.stream(trees).max().getAsLong();

        while (min <= max) {
            int mid = (max + min) / 2;
            long sum = 0;
            for (long tree : trees) {
                sum += Math.min(mid, tree);
            }

            if (sum > goal) {
                max = mid - 1;
            }
            else if (sum<goal) {
                min = mid + 1;
            }
            else {
                max = mid;
                break;
            }
        }

        System.out.println(max);
        br.close();
    }
}
