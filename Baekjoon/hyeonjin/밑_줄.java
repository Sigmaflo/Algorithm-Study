import java.io.*;
import java.util.*;

public class 밑_줄 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(str.nextToken());
        int M = Integer.valueOf(str.nextToken());

        String[] arr = new String[N];
        StringBuffer sb = new StringBuffer();
        int wordSize = 0;
        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
            wordSize += arr[i].length();
        }

        int eachBlank = (M - wordSize) / (N - 1);
        int emptyBlank = (M - wordSize) % (N - 1);

        //소문자 앞에 더하기
        for(int i = 1; i < N; i++){
            if(emptyBlank == 0) break;

            if(arr[i].charAt(0) >= 'a' && arr[i].charAt(0) <= 'z'){
                arr[i] = '_' + arr[i];
                emptyBlank--;
            }
        }

        //대문자 앞에 더하기
        for(int i = N - 1; i > 0; i--){
            if(emptyBlank == 0) break;

            if(arr[i].charAt(0) >= 'A' && arr[i].charAt(0) <= 'Z'){
                arr[i] = '_' + arr[i];
                emptyBlank--;
            }
        }

        sb.append(arr[0]);
        for(int i = 1; i < N; i++){
            for(int j = 0; j < eachBlank; j++){
                sb.append('_');
            }
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}
