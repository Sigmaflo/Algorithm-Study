import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 효율적인_해킹 {
    private static  Computer[] computers;
    private static int[] counts;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        computers = new Computer[N + 1];
        counts = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            computers[i] = new Computer(i);
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            computers[B].connected.add(computers[A]);
        }

        int max = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int cnt = getCountConnected(computers[i]);
            if (max < cnt) {
                max = cnt;
                answer = new StringBuilder();
            }
            if (cnt == max) answer.append(i).append(" ");
        }

        System.out.println(answer);
        br.close();
    }

    private static int getCountConnected(Computer computer) {
        int cnt = computer.connected.size();
        for (Computer c : computer.connected) {
            if (visit[c.number]) continue;
            visit[c.number] = true;
            counts[c.number] = getCountConnected(c);
            visit[c.number] = false;
            cnt += counts[c.number];
        }
        return cnt;
    }

    static class Computer {
        int number;
        Set<Computer> connected = new HashSet<>();

        public Computer(int number) {
            this.number = number;
        }
    }
}
