import java.io.*;
import java.util.*;

public class 전화번호_목록 {
    static int N;
    static String[] phone;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.valueOf(br.readLine());

        for(int t = 0; t < T; t++){
            N = Integer.valueOf(br.readLine());
            phone = new String[N];

            for (int i = 0; i < N; i++) {
                phone[i] = br.readLine();
            }

            Arrays.sort(phone);

            if (checkPhone())  bw.write("YES");
            else  bw.write("NO");

            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static boolean checkPhone() {
        for (int i = 0; i < N - 1; i++) {
            if (phone[i + 1].startsWith(phone[i])) return false;
        }
        return true;
    }

}
