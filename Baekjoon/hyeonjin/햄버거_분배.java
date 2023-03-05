import java.io.*;
import java.util.*;

public class 햄버거_분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        char[] list = new char[N];
        boolean[] check = new boolean[N];

        for(int i=0; i<N; i++){
            list[i] = str.charAt(i);
        }

        int result = 0;
        for(int i=0; i<N; i++){
            if(list[i]=='P') {
                for(int j=Math.max(i-K, 0); j<=Math.min(i+K, N-1); j++){
                    if(list[j]=='H' && !check[j]){
                        check[j] = true;
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
