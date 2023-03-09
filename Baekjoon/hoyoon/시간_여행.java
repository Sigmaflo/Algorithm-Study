import java.io.*;

public class 시간_여행 {
    private static final int NOTHING = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] history = new int[N + 1][2];

        history[0] = new int[]{NOTHING, NOTHING};
        for (int i = 1; i <= N; i++) {
            String[] query = br.readLine().split(" ");
            switch (query[0]) {
                case "a":
                    history[i] = new int[]{i - 1, Integer.parseInt(query[1])};
                    break;
                case "s":
                    history[i] = history[Math.max(history[i - 1][0], 0)];
                    break;
                case "t":
                    int time = Integer.parseInt(query[1]) - 1;
                    history[i] = history[time];
                    break;
            }
            bw.write(history[i][1] + "\n");
        }

        br.close();
        bw.close();
    }
}
