import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[] nums, result;
    static boolean[] seleted;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        seleted = new boolean[N];
        result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void calculation(int[] op) {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(op[i] - op[i + 1]);
        }
        ans = Math.max(ans, sum);
    }

    static void rec_func(int k) {
        if (k == N) {
            calculation(result);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (seleted[i]) continue;
            seleted[i] = true;
            result[k] = nums[i];
            rec_func(k + 1);
            seleted[i] = false;
        }
    }

    static void pro() {
        ans = Integer.MIN_VALUE;
        rec_func(0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
