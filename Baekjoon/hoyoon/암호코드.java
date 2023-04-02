import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 암호코드 {
    private static final int MOD = 1000000;

    private static int[] countsByStarts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        countsByStarts = new int[code.length()];
        Arrays.fill(countsByStarts, -1);

        System.out.println(getCounts(code));
        br.close();
    }

    private static int getCounts(String code) {
        int count = 0;
        int idx = countsByStarts.length - code.length();
        if (countsByStarts[idx] != -1)
            return countsByStarts[idx];

        if (code.startsWith("0")) return 0;

        for (int i = 1; i <= 2 && i <= code.length(); i++) {
            int n = Integer.parseInt(code.substring(0, i));
            if (0 < n && n <= 26) {
                if (i == code.length()) {
                    count++;
                    continue;
                }
                count += getCounts(code.substring(i));
            }
        }
        countsByStarts[idx] = count;
        return count % MOD;
    }
}
