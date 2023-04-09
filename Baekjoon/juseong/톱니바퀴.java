import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] A;
    static int[][] cmd;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = new char[5][];
        for (int i = 1; i < 5; i++) {
            A[i] = br.readLine().toCharArray();
        }
        int n = Integer.parseInt(br.readLine());
        cmd = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cmd[i][0] = Integer.parseInt(st.nextToken());
            cmd[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
