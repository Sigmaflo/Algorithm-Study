import java.io.*;
import java.util.*;

public class 나무_자르기 {
    static int N;
    static int M;
    static long[] arr;
    static long maxHeight = 0;
    static long result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str = new StringTokenizer(br.readLine());

        N = Integer.valueOf(str.nextToken());
        M = Integer.valueOf(str.nextToken());
        arr = new long[N];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++) {
            arr[i] = Integer.valueOf(str.nextToken());
            maxHeight = Math.max(arr[i], maxHeight);
        }

        binarySearch(0, maxHeight);
        System.out.println(result);
    }
    private static void binarySearch(long left, long right) {

        while(left <= right) {
            long mid = (left + right) / 2;
            long empty = 0;

            for(int i = 0; i < N; i++) {
                empty += (arr[i] - mid) > 0 ? arr[i] - mid : 0;
                if(empty >= M) break;
            }

            if(empty >= M) {
                left = mid + 1;
                result = mid;
            }
            else right = mid - 1;
        }

    }
}
