import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 여행_가자 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());
        int[][] map = new int[n][];
        int[] plan;

        parent = new int[n];

        for(int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            parent[i] = i;
        }
        plan = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).map(i -> i - 1).toArray();
        br.close();

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(map[i][j] == 1){
                    int ip = findParent(i), jp = findParent(j);
                    parent[jp] = ip;
                }
            }
        }

        int p = findParent(plan[0]);
        for(int i = 1; i < m; i++){
            if(p != findParent(plan[i])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static int findParent(int child){
        if(child == parent[child])
            return child;
        else
            return (parent[child] = findParent(parent[child]));
    }
}
