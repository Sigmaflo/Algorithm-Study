import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 가운데를_말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()) - 1;
        PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> higher = new PriorityQueue<>();

        int mid = Integer.parseInt(br.readLine());
        bw.write(mid + "\n");

        while (N-- > 0) {
            int number = Integer.parseInt(br.readLine());

            if (lower.size() < higher.size()) {
                if (mid > number) {
                    lower.offer(number);
                } else {
                    lower.offer(mid);
                    if (!higher.isEmpty() && higher.peek() < number){
                        mid = higher.poll();
                        higher.offer(number);
                    } else {
                        mid = number;
                    }
                }
            } else {
                if (mid < number) {
                    higher.offer(number);
                } else {
                    higher.offer(mid);
                    if (!lower.isEmpty() && lower.peek() > number) {
                        mid = lower.poll();
                        lower.offer(number);
                    } else {
                        mid = number;
                    }
                }
            }
            bw.write(mid + "\n");
        }

        br.close();
        bw.close();
    }
}
