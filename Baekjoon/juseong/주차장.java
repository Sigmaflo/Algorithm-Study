import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, count;
    static long[] S, W;
    static int[] visit;
    static Queue<Integer> Q = new LinkedList<>();
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        S = new long[n];
        visit = new int[n];
        W = new long[m+1];
        for (int i = 0; i < n; i++) S[i] = Integer.parseInt(br.readLine());
        for (int i = 1; i <= m; i++) W[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < m * 2; i++) {
            int c = Integer.parseInt(br.readLine());
            if (c > 0) {
                ans += park(c);
            } else {
                ans += bye(c);
            }
        }
        System.out.println(ans);
    }

    static long park(int num) {
        if (count < n) {
            for (int i = 0; i < n; i++) {
                if (visit[i] == 0) {
                    visit[i] = num;
                    count++;
                    return S[i] * W[num];
                }
            }
        }
        Q.add(num);
        return 0;
    }

    static long bye(int c) {
        c *= -1;
        for (int i = 0; i < n; i++) {
            if (visit[i] == c) {
                if (Q.size() > 0) {
                    int num = Q.poll();
                    visit[i] = num;
                    return S[i] * W[num];
                } else {
                    visit[i] = 0;
                    count--;
                }
                break;
            }
        }
        return 0;
    }
}
