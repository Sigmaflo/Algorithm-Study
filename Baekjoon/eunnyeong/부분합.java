import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int ans = Integer.MAX_VALUE;
        int[] a = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        int p1 = 0, p2 = 0, sum = a[0];
        while (true) {
            int f = 0;
            if (sum < s && p2 < n) {
                sum += a[p2];
                f = 1;
                if (sum >= s)
                    ans = Math.min(p2 - p1 + 1, ans);
                p2++;
            }
            else {
                if (p1 < n)
                    sum -= a[p1];
                if (sum >= s)
                    ans = Math.min(p2 - p1 + 1, ans);
                p1++;
            }



            if (p1 == n) break;
        }
        if (ans == Integer.MAX_VALUE)
            ans = 0;
        System.out.print(ans);
        br.close();
    }
}
