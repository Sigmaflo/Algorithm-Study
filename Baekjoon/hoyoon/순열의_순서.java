import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 순열의_순서 {
    private static boolean[] visit;
    private static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        String type = st.nextToken();
        long gap = 1L;

        for (int i = N - 1; i > 1; i--) gap *= i;

        switch (type) {
            case "1":
                long k = Long.parseLong(st.nextToken());
                String answer = getKthPermutation(k, gap, N - 1);
                System.out.println(answer);
                break;
            case "2":
                int[] permutation = Arrays.stream(st.nextToken("\n").trim().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                long result = getPermutationCount(permutation, 0, gap);
                System.out.println(result);
                break;
        }

        br.close();
    }

    private static String getKthPermutation(long k, long gap, int cnt) {
        int i;
        for (i = 0; i < N; i++) {
            if (visit[i]) continue;
            if (k - gap <= 0) break;
            k -= gap;
        }
        visit[i] = true;
        return String.format("%d %s", i + 1, cnt == 0? "" : getKthPermutation(k, gap / cnt, cnt - 1));
    }

    private static long getPermutationCount(int[] permutation, int idx, long gap) {
        if (idx + 1 == permutation.length) return 0;
        long cnt = 0;
        for (int i = 0; i < N && i + 1 < permutation[idx]; i++) {
            if (visit[i]) continue;
            cnt += gap;
        }
        visit[permutation[idx]] = true;
        idx++;
        return cnt + getPermutationCount(permutation, idx, gap / (permutation.length - idx));
    }
}
