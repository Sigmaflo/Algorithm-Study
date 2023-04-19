import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질_3 {
    private static final int MAX = 100001;
    private static final int[] CALC = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = K < N? N - K : getMinCount(N, K);

        System.out.println(answer);
        br.close();
    }

    private static int getMinCount(int now, int goal) {
        boolean[] visit = new boolean[MAX];
        Queue<Integer> q = new LinkedList<>();
        q.offer(now);

        int cnt = 0;
        LOOP:
        while (true) {
            int size = q.size();
            while (size-- > 0) {
                int n = q.poll();

                while (true){
                    if (n == goal) break LOOP;
                    if (n < 0 || MAX <= n) break;
                    visit[n] = true;
                    for (int j = 0; j < 2; j++) {
                        int next = n + CALC[j];
                        if (0 <= next && next < MAX && !visit[next]) {
                            q.offer(next);
                            visit[next] = true;
                        }
                    }
                    if (n > goal) break;
                    n *= 2;
                }
            }
            cnt++;
        }
        return cnt;
    }
}
