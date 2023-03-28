import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 소수의_곱 {
    private static final long MAX = (long) 2 << 30;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] primes = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        PriorityQueue<Long> pq = Arrays.stream(primes)
                .mapToObj(Long::valueOf)
                .collect(Collectors.toCollection(PriorityQueue::new));
        long n = 0;

        while (N-- > 0) {
            n = pq.poll();
            for (int p : primes) {
                long calc = n * p;
                if (calc < MAX) pq.offer(calc);
                if (n % p == 0) break;
            }
        }

        System.out.println(n);
        br.close();
    }
}
