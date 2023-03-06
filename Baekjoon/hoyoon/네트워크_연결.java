import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Link {
    int computer1;
    int computer2;
    int weight;

    public Link(int computer1, int computer2, int weight) {
        this.computer1 = Math.min(computer1, computer2);
        this.computer2 = Math.max(computer1, computer2);
        this.weight = weight;
    }
}

public class 네트워크_연결 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        int[] depth = new int[N + 1];
        int answer = 0;
        PriorityQueue<Link> pq = new PriorityQueue<>(Comparator.comparingInt(link -> link.weight));

        for(int i = 1; i <= N; i++) {
            parent[i] = i;
            depth[i] = 1;
        }

        while (M-- > 0) {
            int[] w = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            pq.offer(new Link(w[0], w[1], w[2]));
        }

        while (!pq.isEmpty()) {
            Link link = pq.poll();
            int a1 = findAncestor(link.computer1);
            int a2 = findAncestor(link.computer2);
            if (a1 != a2) {
               int p = depth[a1] > depth[a2]? a1 : a2;
               int c = p == a1? a2 : a1;

               parent[c] = parent[p];
               depth[p] += depth[c];
               answer += link.weight;
            }
        }

        System.out.println(answer);
        br.close();
    }

    private static int findAncestor(int computer) {
        if(computer != parent[computer])
            parent[computer] = findAncestor(parent[computer]);
        return parent[computer];
    }
}
