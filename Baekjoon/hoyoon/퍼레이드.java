import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퍼레이드 {
    private static int[] parent;
    private static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[] countEdges = new int[V];
        parent = new int[V];
        depth = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            depth[i] = 1;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            countEdges[v1]++;
            countEdges[v2]++;

            int a1 = findAncestor(v1);
            int a2 = findAncestor(v2);

            if (a1 == a2) continue;
            if (depth[a1] < depth[a2]) {
                int tmp = a1;
                a1 = a2;
                a2 = tmp;
            }
            parent[a2] = a1;
            depth[a1] += a2;
        }

        int cnt = 0;
        for (int i = 0; i < V && cnt < 2; i++) {
            if (parent[i] == i) cnt++;
        }

        long count = Arrays.stream(countEdges)
                .filter(i -> i % 2 == 1)
                .count();

        if (cnt < 2 && (count == 0 || count == 2)) System.out.println("YES");
        else System.out.println("NO");
        br.close();
    }

    private static int findAncestor(int v) {
        if (parent[v] != v) parent[v] = findAncestor(parent[v]);
        return parent[v];
    }
}
