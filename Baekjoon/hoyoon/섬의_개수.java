import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의_개수 {
    private static final int[] ud = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static final int[] lr = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            int answer = 0;
            String[][] map = new String[h][w];

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().split(" ");
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j].equals("0")) continue;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i);
                    queue.offer(j);
                    map[i][j] = "0";

                    while (!queue.isEmpty()) {
                        int y = queue.poll();
                        int x = queue.poll();

                        for (int m = 0; m < ud.length; m++) {
                            int ny = y + ud[m];
                            int nx = x + lr[m];

                            if(ny < 0 || h <= ny || nx < 0 || w <= nx
                                    || map[ny][nx].equals("0")) continue;
                            map[ny][nx] = "0";
                            queue.offer(ny);
                            queue.offer(nx);
                        }
                    }
                    answer++;
                }
            }
            bw.write(answer + "\n");
        }

        br.close();
        bw.close();
    }
}
