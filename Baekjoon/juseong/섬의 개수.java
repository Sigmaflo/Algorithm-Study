import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int w, h, ans;
    static int[][] board;
    static boolean[][] visit;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    static boolean input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        board = new int[h][w];
        visit = new boolean[h][w];
        if(w == 0 || h == 0) return false;
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return true;
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int k = 0; k < 8; k++) {
            int nx = x + dir[k][0], ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
            if (visit[nx][ny]) continue;
            if (board[nx][ny] == 0) continue;
            visit[nx][ny] = true;
            dfs(nx, ny);
        }
    }
    static void pro() {
        ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(board[i][j] == 0 || visit[i][j]) continue;
                ans++;
                dfs(i, j);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        boolean con = input();
        while(con) {
            pro();
            con = input();
        }

    }
}
