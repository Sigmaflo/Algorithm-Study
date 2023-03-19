import java.io.*;
import java.util.Arrays;

public class 먹을_것인가_먹힐_것인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            br.readLine();
            int[] A = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int[] B = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int[] count = new int[A.length + 1];
            int idx = 0;

            for (int i = 0; i < A.length; i++) {
                int cnt = 0;
                for (; idx < B.length && B[idx] < A[i]; idx++) {
                    cnt++;
                }
                count[i + 1] = count[i] + cnt;
            }
            bw.write(Arrays.stream(count).sum() + "\n");
        }

        br.close();
        bw.close();
    }
}
