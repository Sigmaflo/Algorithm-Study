import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정_거리의_도시_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<List<Integer>> map = new ArrayList<>();
        int[] distance = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            map.get(A).add(B);
        }

        Arrays.fill(distance, -1);

        Queue<Integer> pq = new LinkedList<>();
        pq.offer(X);
        distance[X] = 0;

        while (!pq.isEmpty()) {
            int x = pq.poll();
            for (int next : map.get(x)) {
                if (distance[next] == -1) {
                    distance[next] = distance[x] + 1;
                    pq.offer(next);
                }
            }
        }

        if (Arrays.stream(distance).noneMatch(d -> d == K)) {
            System.out.println(-1);
        }
        else {
            for (int i = 1; i <= N; i++) {
                if (distance[i] == K)
                    System.out.println(i);
            }
        }
        br.close();
    }
}
