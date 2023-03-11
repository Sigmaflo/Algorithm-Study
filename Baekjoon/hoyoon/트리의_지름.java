import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Vertex {
    int name;
    Map<Vertex, Integer> next = new HashMap<>();
    boolean isVisited = false;

    public Vertex(int name) {
        this.name = name;
    }
}

public class 트리의_지름 {
    private static Vertex maxVertex;
    private static int maxLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        Vertex[] vertices = new Vertex[V + 1];

        for (int i = 1; i <= V; i++) {
            vertices[i] = (new Vertex(i));
        }

        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int v;

            while ((v = Integer.parseInt(st.nextToken())) != -1) {
                int w = Integer.parseInt(st.nextToken());
                vertices[n].next.put(vertices[v], w);
            }
        }

        Vertex farthestVertex = findFarthestVertex(vertices[1]);
        findFarthestVertex(farthestVertex);

        System.out.println(maxLen);
        br.close();
    }

    private static Vertex findFarthestVertex(Vertex v) {
        maxVertex = null;
        maxLen = 0;
        v.isVisited = true;
        dfs(v, 0);
        v.isVisited = false;
        return maxVertex;
    }

    private static void dfs(Vertex v, int len) {
        if (len > maxLen) {
            maxLen = len;
            maxVertex = v;
        }

        for (Map.Entry<Vertex, Integer> e : v.next.entrySet()) {
            if (e.getKey().isVisited) continue;
            e.getKey().isVisited = true;
            dfs(e.getKey(), len + e.getValue());
            e.getKey().isVisited = false;
        }
    }
}