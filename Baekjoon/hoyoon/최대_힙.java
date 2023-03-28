import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 최대_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                bw.write((pq.isEmpty() ? 0 : pq.poll()) + "\n");
            } else {
                pq.offer(x);
            }
        }

        br.close();
        bw.close();
    }
}
