import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 주차장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] R = new int[N];
        int[] W = new int[M + 1];
        int[] parkingArea = new int[M + 1];
        int answer = 0;

        PriorityQueue<Integer> emptySpaces = new PriorityQueue<>();
        Queue<Integer> waitingCars = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            R[i] = Integer.parseInt(br.readLine());
            emptySpaces.offer(i);
        }

        for (int i = 1; i <= M; i++) {
            W[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 2 * M; i++) {
            int car = Integer.parseInt(br.readLine());
            if (car > 0) waitingCars.offer(car);
            else emptySpaces.offer(parkingArea[-car]);

            while (!waitingCars.isEmpty() && !emptySpaces.isEmpty()) {
                car = waitingCars.poll();
                int emptySpace = emptySpaces.poll();
                parkingArea[car] = emptySpace;
                answer += R[emptySpace] * W[car];
            }
        }

        System.out.println(answer);
        br.close();
    }
}
