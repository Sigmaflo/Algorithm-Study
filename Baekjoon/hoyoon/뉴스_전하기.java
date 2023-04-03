import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 뉴스_전하기 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parents = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(findMinTime(0));

        br.close();
    }

    private static int findMinTime(int number) {
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < parents.length; i++)
            if(parents[i] == number) pq.offer(findMinTime(i));

        int order = 1;
        while (!pq.isEmpty())
            time = Math.max(time, pq.poll() + order++);

        return time;
    }
}
