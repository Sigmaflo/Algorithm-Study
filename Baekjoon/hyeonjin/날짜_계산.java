import java.io.*;
import java.util.*;

public class 날짜_계산 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int E = Integer.valueOf(str.nextToken());
        int S = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());

        int e = 1;
        int s = 1;
        int m = 1;

        int cnt = 1;
        while(E != e || S != s || M != m){
            cnt++;
            e++;
            s++;
            m++;

            if(e > 15) e = 1;
            if(s > 28) s = 1;
            if(m > 19) m = 1;
        }

        System.out.println(cnt);
    }
}
