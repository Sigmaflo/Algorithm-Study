import java.io.*;

public class 폰트 {
    static final int PERFECT = (1 << 26) - 1;
    static int[] arr;
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");

            for (int j = 0; j < input.length; j++) {
                arr[i] |= 1 << input[j].charAt(0) - 'a';
            }
        }

        dfs(-1, 0);

        System.out.println(answer);
    }

    static void dfs(int count, int mask) {
        if (count == n - 1) {
            if (mask == PERFECT) answer++;
            return;
        }

        dfs(count + 1, mask | arr[count+1]);
        dfs(count + 1, mask);
    }
}