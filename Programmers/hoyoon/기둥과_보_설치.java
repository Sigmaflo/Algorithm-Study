import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기둥과_보_설치 {
    static class Solution {
        private final int EMPTY = -1;
        private final int PILLAR = 0;
        private final int BEAM = 1;

        private int n;
        private int[][] map;

        public int[][] solution(int n, int[][] build_frame) {
            List<int[]> answer = new ArrayList<>();
            this.n = n;
            map = new int[n + 1][n + 1];

            for (int i = 0; i <= n; i++) {
                Arrays.fill(map[i], EMPTY);
            }

            for (int[] command : build_frame) {
                if (command[3] == 0) {
                    delete(command[1], command[0], command[2]);
                } else if (command[3] == 1) {
                    add(command[1], command[0], command[2]);
                }
            }

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (map[j][i] != -1) {
                        answer.add(new int[]{i, j, map[j][i]});
                    }
                }
            }
            return answer.toArray(int[][]::new);
        }

        private void delete(int x, int y, int type) {
            if (type == 0) deletePillar(x, y);
            else deleteBeam(x, y);
        }

        private void deletePillar(int x, int y) {
            if (map[x][y] == PILLAR
                    && (map[x + 1][y] == EMPTY && (y == 0 || map[x + 1][y - 1] == EMPTY))) {
                map[x][y] = EMPTY;
            }
        }

        private void deleteBeam(int x, int y) {
            if (map[x][y] == BEAM
                    && (y == n || map[x][y + 1] == EMPTY)
                    && (y == 0 || map[x][y - 1] != BEAM)) {
                map[x][y] = EMPTY;
            }
        }

        private void add(int x, int y, int type) {
            if (type == 0) addPillar(x, y);
            else addBeam(x, y);
        }

        private void addPillar(int x, int y) {
            if (map[x][y] == EMPTY
                    && (x == 0 || map[x - 1][y] == PILLAR || (y > 0 && map[x][y - 1] == BEAM)))
                map[x][y] = PILLAR;
        }

        private void addBeam(int x, int y) {
            if (map[x][y] == EMPTY
                    && (x > 0 && (map[x - 1][y] == PILLAR || (y < n && map[x - 1][y + 1] == PILLAR)
                        || (y > 0 && y < n && map[x][y - 1] == BEAM && map[x][y + 1] == BEAM))))
                map[x][y] = BEAM;
        }
    }

    public static void main(String[] args) {
//        int[][] build_frame = {
//                {1, 0, 0, 1},
//                {1, 1, 1, 1},
//                {2, 1, 0, 1},
//                {2, 2, 1, 1},
//                {5, 0, 0, 1},
//                {5, 1, 0, 1},
//                {4, 2, 1, 1},
//                {3, 2, 1, 1}
//        };
        int[][] build_frame = {
                {0, 0, 0, 1},
                {2, 0, 0, 1},
                {4, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {2, 1, 1, 1},
                {3, 1, 1, 1},
                {2, 0, 0, 0},
                {1, 1, 1, 0},
                {2, 2, 0, 1}
        };
        int[][] solution = new Solution().solution(5, build_frame);
        for (int[] s : solution) {
            System.out.println(Arrays.toString(s));
        }
    }
}
