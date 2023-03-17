import java.io.*;
import java.util.*;

public class Main {
    public static StringTokenizer stk;
    public static StringBuilder sb = new StringBuilder();
    public static int n;
    public static long[] factorial;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        factorial = new long[n + 1];                //Factorial값 미리 구해서 저장
        boolean[] isUsed = new boolean[n + 1];      //i번째 숫자 사용 여부
        getFactorial();

        stk = new StringTokenizer(br.readLine());
        int type = Integer.parseInt(stk.nextToken());
        if (type == 1) {
            long k = Long.parseLong(stk.nextToken()) - 1;
            for (int i = n; i > 0; i--) {
                long mod = k / factorial[i - 1] + 1;    //i번째에서 몇 번째 숫자를 선택할 지 구한다
                k %= factorial[i - 1];
                long cnt = 0;       //mod 번째 숫자를 찾기 위한 변수
                int idx = 0;        //앞에서부터 해당 숫자를 확인할 때 사용하는 변수
                while (cnt != mod) {
                    idx++;
                    if (!isUsed[idx]) cnt++;
                }
                isUsed[idx] = true;
                sb.append(idx + " ");
            }
        } else {
            long ans = 0;
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(stk.nextToken());
                long cnt = 0;       //움직이는 횟수
                int idx = 0;        //idx 숫자를 사용했는지 확인하는 변수
                while (num[i] != idx) {
                    idx++;
                    if (!isUsed[idx]) cnt++;
                }
                isUsed[idx] = true;
                ans += (cnt - 1) * factorial[n - i - 1];
            }
            sb.append(ans + 1);
        }
        System.out.println(sb);
    }

    public static void getFactorial() {     //factorial값 구하는 함수
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}
