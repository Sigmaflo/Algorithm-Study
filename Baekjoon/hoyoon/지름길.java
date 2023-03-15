import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Route {
    int start;
    int end;
    int distance;

    public Route(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }
}

public class 지름길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] shortest = new int[D + 1];
        List<Route> routes = new ArrayList<>();

        Arrays.fill(shortest, 10001);

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if (end > D) continue;
            if (end - start <= dist) continue;
            routes.add(new Route(start, end, dist));
        }

        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparing(r -> r.distance));

        pq.offer(new Route(0, 0, 0));
        shortest[0] = 0;

        while (!pq.isEmpty()) {
            Route now = pq.poll();

            for (Route route : routes) {
                if (route.start < now.end) continue;
                if (shortest[route.end] > shortest[now.end] + route.distance + (route.start - now.end)) {
                    shortest[route.end] = shortest[now.end] + route.distance + (route.start - now.end);
                    pq.offer(new Route(now.end, route.end, shortest[route.end]));
                }
            }
            shortest[D] = Math.min(shortest[D], shortest[now.end] + D - now.end);
        }

        System.out.println(shortest[D]);
        br.close();
    }
}
