import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 컨베이어_벨트_위의_로봇 {
    private static int[] A;
    private static boolean[] conveyorBelt;
    private static int cntZero = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        conveyorBelt = new boolean[A.length];
        int putPos = 0;
        int offloadPos = N - 1;
        int answer = 0;

        while (cntZero < K) {
            answer++;

            putPos = getIndexBefore(putPos);
            offloadPos = getIndexBefore(offloadPos);
            offload(offloadPos);

            for (int i = getIndexBefore(offloadPos); i != offloadPos; i = getIndexBefore(i) ) {
                if (!conveyorBelt[i]) continue;
                int next = (i + 1) % A.length;
                if (put(next)) offload(i);
                if (next == offloadPos) offload(offloadPos);
            }

            put(putPos);
        }

        System.out.println(answer);
        br.close();
    }

    private static int getIndexBefore(int idx) {
        return (--idx + A.length) % A.length;
    }

    private static void offload(int offloadPosition) {
        if (!conveyorBelt[offloadPosition]) return;
        conveyorBelt[offloadPosition] = false;
    }

    private static boolean put(int putPosition) {
        if (conveyorBelt[putPosition] || A[putPosition] == 0) return false;
        conveyorBelt[putPosition] = true;
        A[putPosition]--;
        if (A[putPosition] == 0) cntZero++;
        return true;
    }
}
