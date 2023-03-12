import java.io.*;
import java.util.*;

public class 가운데를_말해요 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq_min = new PriorityQueue<>();
        PriorityQueue<Integer> pq_max = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.valueOf(br.readLine());
        for(int i = 0; i < N ; i++){
            int num = Integer.valueOf(br.readLine());

            if(pq_max.size() == pq_min.size()) pq_max.add(num);
            else pq_min.add(num);

            if(!pq_max.isEmpty() && !pq_min.isEmpty() && pq_min.peek() < pq_max.peek()) {
                int tmp = pq_min.poll();
                pq_min.add(pq_max.poll());
                pq_max.add(tmp);
            }

            bw.write(String.valueOf(pq_max.peek()));
            bw.newLine();
        }
        bw.flush();
    }
}
