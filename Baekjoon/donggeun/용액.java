import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = n-1;
        long leftAns = 0;
        long rightAns = 0;
        long shake = Long.MAX_VALUE;
        while (left < right) {
            long tmp = arr[left] + arr[right];
            if (Math.abs(tmp) < shake) {
                shake = Math.abs(tmp);
                leftAns = arr[left];
                rightAns = arr[right];
            }
            if (tmp < 0) {
                left++;
            } else if (tmp > 0) {
                right--;
            } else {
                leftAns = arr[left];
                rightAns = arr[right];
                break;
            }
        }
        System.out.println(leftAns + " " + rightAns);
    }
}
