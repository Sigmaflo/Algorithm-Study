import java.io.*;
import java.util.*;

public class N번째_큰_수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                pq.add(Integer.valueOf(str.nextToken()));
            }
        }

        for(int i = 1; i < N; i++){
            pq.poll();
        }

        System.out.println(pq.peek());
    }
}
