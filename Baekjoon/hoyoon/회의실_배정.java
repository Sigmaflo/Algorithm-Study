import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting m) {
        return this.end != m.end? this.end - m.end : this.start - m.start;
    }
}

public class 회의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> meetings = new PriorityQueue<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Meeting m = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            meetings.offer(m);
        }

        Meeting now = meetings.poll();
        int answer = 1;

        LOOP:
        while (true) {
            Meeting next;
            do {
                if(meetings.isEmpty()) break LOOP;
                next = meetings.poll();
            } while (now.end > next.start);
            now = next;
            answer++;
        }

        System.out.println(answer);
        br.close();
    }
}
