import java.io.*;
import java.util.*;

public class 나무_재테크 {
    static int N, M, K;
    static int[][] map;
    static int[][] arr;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    static LinkedList<Tree> trees;
    static Queue<Tree> dead;

    static class Tree {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken());

        map = new int[N + 1][N + 1];
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            str = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = 5;
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        trees = new LinkedList<>();
        dead = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int x = Integer.valueOf(str.nextToken());
            int y = Integer.valueOf(str.nextToken());
            int z = Integer.valueOf(str.nextToken());

            trees.add(new Tree(x,y,z));
        }

        for(int i = 0; i < K; i++){
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(trees.size());
    }

    private static void winter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] += arr[i][j];
            }
        }
    }

    private static void fall() {
        LinkedList<Tree> babyTrees = new LinkedList<>();
        for (Tree tree : trees) {
            int r = tree.x;
            int c = tree.y;
            if (tree.age % 5 != 0) continue;
            for (int d = 0; d < 8; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 1 || nc < 1 || nr > N || nc > N) continue;
                babyTrees.add(new Tree(nr, nc, 1));
            }
        }
        trees.addAll(0, babyTrees);
    }

    private static void summer() {
        while (!dead.isEmpty()) {
            Tree tree = dead.poll();
            map[tree.x][tree.y] += tree.age / 2;
        }
    }

    private static void spring() {
        Iterator<Tree> iterator = trees.iterator();
        while (iterator.hasNext()) {
            Tree tree = iterator.next();
            int r = tree.x;
            int c = tree.y;
            int age = tree.age;
            if (map[r][c] - age < 0) {
                dead.offer(tree);
                iterator.remove();
            } else {
                map[r][c] -= age;
                tree.age += 1;
            }
        }
    }


}
