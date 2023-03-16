import java.io.*;
import java.util.*;

public class Main {
    public static int n, k;
    public static int[] a;
    public static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[2 * N];
        robot = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) 
            a[i] = Integer.parseInt(st.nextToken());

        bw.write(simulation(0) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int simulation(int cnt) {
        while (isOK()) {
            int temp = a[a.length - 1]; // 1. 벨트 한 칸 회전
            for (int i = a.length - 1; i > 0; i--)
                a[i] = a[i - 1];
      
            a[0] = temp;
            for (int i = robot.length - 1; i > 0; i--)    // 로봇도 벨트와 같이 회전
                robot[i] = robot[i - 1];
            
            robot[0] = false;

            robot[n - 1] = false;
            for (int i = N - 1; i > 0; i--) {   // 2. 로봇 이동가능하면 이동
                if (robot[i - 1] && !robot[i] && a[i] >= 1) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    a[i]--;
                }
            }

            if (a[0] > 0) {     // 3. 올라가는 위치에 로봇 올리기
                robot[0] = true;
                a[0]--;
            }
            
            cnt++;
        }

        return cnt;
    }

    public static boolean isOK() {
        int cnt = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                cnt++;
           
            if (cnt >= K)
                return false;
        }
        return true;
    }
}
