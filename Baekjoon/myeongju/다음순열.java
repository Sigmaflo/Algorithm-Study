import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        if (np(arr)) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static boolean np(int[] input) {
        int idx = N - 1;

        while (idx > 0 && input[idx - 1] > input[idx]) idx--;

        if (idx == 0) {
            System.out.println("-1");
            return false;
        }

        int idx2 = N - 1;
        while (arr[idx - 1] >= arr[idx2]) idx2--;

        swap(arr, idx - 1, idx2);

        int k = N - 1;
        while (idx < k) swap(arr, idx++, k--);

        return true;
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}