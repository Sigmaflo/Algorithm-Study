import java.io.*;
import java.util.*;

public class 순열의_순서 {
    static int N;
    static boolean end = false;
    static long value;
    static int[] arr = new int[21];
    static long[] factorial = new long[21];
    static boolean[] visited = new boolean[21];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;

        N = Integer.valueOf(br.readLine());
        str = new StringTokenizer(br.readLine());

        getFactorial(N);

        if(str.nextToken().equals("1")) {
            value = Long.valueOf(str.nextToken());
            findSeq();
        }
        else {
            for(int i = 1; i <= N; i++) {
                arr[i] = Integer.valueOf(str.nextToken());
            }

            findOrder();
        }
    }

    private static void findSeq() {
        String s = "";
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(visited[j]) continue;
                long num = factorial[N - i];

                if(num < value) value -= num;
                else {
                    s += j + " ";
                    visited[j] = true;
                    break;
                }
            }
        }

        System.out.println(s);
    }

    private static void findOrder() {
        long num = 1L;

        for(int i = 0; i < N; i++) {
            for(int j = 1; j < arr[i]; j++) {
                if(!visited[j]) num += factorial[N - i];
            }
            visited[arr[i]] = true;
        }

        System.out.println(num);
    }

    private static void getFactorial(int n) {
        factorial[0] = 1;
        factorial[1] = 1;
        for(int i = 2; i <= N; i++) {
            factorial[i] = i * factorial[i - 1];
        }

    }
}