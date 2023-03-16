import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Land {
    int food = 5;
    int winterFood;
    Deque<Integer> aliveTrees = new ArrayDeque<>();

    public Land(int winterFood) {
        this.winterFood = winterFood;
    }

    public void plantTree(int age) {
        aliveTrees.offerFirst(age);
    }

    public void plantTrees(int age, long cnt) {
        while (cnt-- > 0) plantTree(age);
    }

    public void growTrees() {
        int size = aliveTrees.size();
        int i;
        for (i = 0; i < size && food >= aliveTrees.peekFirst(); i++) {
            int age = aliveTrees.pollFirst();
            food -= age;
            aliveTrees.offerLast(age + 1);
        }
        for (; i < size; i++) {
            food += aliveTrees.pollFirst() / 2;
        }
    }

    public long countBreedingTrees() {
        return aliveTrees.stream()
                .filter(age -> age % 5 == 0)
                .count();
    }

    public void feedLand() {
        food += winterFood;
    }
}

public class 나무_재테크 {
    private static final int[] ud = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] lr = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Land[][] lands = new Land[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lands[i][j] = new Land(Integer.parseInt(st.nextToken()));
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            lands[x][y].plantTree(age);
        }

        while (K-- > 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    lands[i][j].growTrees();
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    long cnt = lands[i][j].countBreedingTrees();
                    for (int m = 0; m < 8; m++) {
                        int x = i + ud[m];
                        int y = j + lr[m];
                        if (x < 0 || N <= x || y < 0 || N <= y) continue;
                        lands[x][y].plantTrees(1, cnt);
                    }
                    lands[i][j].feedLand();
                }
            }
        }

        long answer = 0L;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += lands[i][j].aliveTrees.size();
            }
        }
        System.out.println(answer);
        br.close();
    }
}
