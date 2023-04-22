import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 사회망_서비스 {
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        int answer;

        for (int i = 0; i < N; i++)
            nodes[i] = new Node(i);

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            nodes[u].friends.add(nodes[v]);
            nodes[v].friends.add(nodes[u]);
        }

        visit = new boolean[N];
        answer = nodes[N - 1].getEACount(true);

        visit = new boolean[N];
        answer = Math.min(answer, nodes[N - 1].getEACount(false));

        System.out.println(answer);
        br.close();
    }

    static class Node {
        int id;
        List<Node> friends = new ArrayList<>();

        public Node(int id) {
            this.id = id;
        }

        public int getEACount(boolean ea) {
            if (visit[id]) return 0;

            int cnt = ea? 1 : 0;
            visit[id] = true;
            for (Node friend : friends)
                cnt += friend.getEACount(!ea);
            return cnt;
        }
    }
}
