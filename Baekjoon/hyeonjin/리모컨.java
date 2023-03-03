import java.io.*;
import java.util.*;

public class 리모컨 {
    static boolean[] broken;
    static int N, M;
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        String s = br.readLine();
        N = Integer.valueOf(s);
        M = Integer.valueOf(br.readLine());

        broken = new boolean[10];
        if(M > 0) {
            str = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.valueOf(str.nextToken())] = true;
            }
        }
        //100에서 +,- 버튼만 눌러서 채널을 맞추는 경우

        result = Math.abs(N - 100);

        for(int i = 0; i < 1_000_000; i++){
            int num = checkMake(i);

            if(num == 0) continue;

            int addOrMinus = Math.abs(i - N);
            result = Math.min(result, addOrMinus + num);
        }

        System.out.println(result);
    }

    private static int checkMake(int num) {
        int result = 0;

        if(num == 0){
            if(broken[0]) return 0;
            else return 1;
        }

        while(num > 0){
            if(broken[num % 10]) return 0;

            result += 1;
            num /= 10;
        }

        return result;
    }
}
