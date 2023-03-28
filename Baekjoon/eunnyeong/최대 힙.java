import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Order> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            q.add(new Order(x));
            if (x == 0)
                sb.append(q.poll().x + "\n");
        }

        bw.write(sb.toString());
        bw.flush(); bw.close(); br.close();
    }

    static class Order implements Comparable<Order>{
        int x;
        public Order(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(Order o) {
            return o.x - this.x;
        }
    }
}
