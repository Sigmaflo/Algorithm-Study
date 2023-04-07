package CodeTree.hoyoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 싸움땅 {
    private static final int[] UD = {-1, 0, 1, 0};
    private static final int[] LR = {0, 1, 0, -1};

    private static int n;
    private static PriorityQueue<Integer>[][] gunsOnMap;
    private static boolean[][] playersOnMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        gunsOnMap =  new PriorityQueue[n][n];
        playersOnMap = new boolean[n][n];
        Player[] players = new Player[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                gunsOnMap[i][j] = new PriorityQueue<>(Comparator.reverseOrder());
                gunsOnMap[i][j].offer(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            players[i] = new Player(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        while (k-- > 0) {
            for (Player player : players) {
                player.move();
                for (Player enemy : players) {
                    if (player.equals(enemy) || player.x != enemy.x || player.y != enemy.y) continue;
                    int playerPower = player.s + player.gun;
                    int enemyPower = enemy.s + enemy.gun;
                    int point = Math.abs(playerPower - enemyPower);
                    if (playerPower == enemyPower) {
                        playerPower = player.s;
                        enemyPower = enemy.s;
                    }
                    Player winner = playerPower < enemyPower? enemy : player;
                    Player looser = playerPower < enemyPower? player : enemy;
                    looser.avoid();
                    winner.point += point;
                    winner.changeGun();
                }
                player.changeGun();
            }
        }

        StringBuilder answer = new StringBuilder();
        for (Player player : players) {
            answer.append(player.point).append(" ");
        }

        System.out.println(answer);
        br.close();
    }

    static class Player {
        int x;
        int y;
        int direction;
        int s;
        int gun = 0;
        int point = 0;

        public Player(int x, int y, int direction, int s) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.s = s;
            playersOnMap[x][y] = true;
        }

        public void move() {
            if (isOutOfMap(x + UD[direction], y + LR[direction]))
                changeDirectionToOpposite();
            playersOnMap[x][y] = false;
            toNextCell();
        }

        public void avoid() {
            while (isOutOfMap(x + UD[direction], y + LR[direction])
                    || isTherePlayer(x + UD[direction], y + LR[direction]))
                changeDirectionToRight();
            gunsOnMap[x][y].offer(gun);
            gun = 0;
            toNextCell();
            changeGun();
        }

        public void changeGun() {
            if (gunsOnMap[x][y].isEmpty()) return;
            int newGun = gunsOnMap[x][y].peek();
            if (newGun > gun) {
                if (gun > 0) gunsOnMap[x][y].offer(gun);
                gun = gunsOnMap[x][y].poll();
            }
        }

        private boolean isOutOfMap(int x, int y) {
            return x < 0 || n <= x || y < 0 || n <= y;
        }

        private boolean isTherePlayer(int x, int y) {
            return playersOnMap[x][y];
        }

        private void toNextCell() {
            x += UD[direction];
            y += LR[direction];
            playersOnMap[x][y] = true;
        }

        private void changeDirectionToOpposite() {
            direction = (direction + 2) % 4;
        }

        private void changeDirectionToRight() {
            direction = (direction + 1) % 4;
        }
    }
}
