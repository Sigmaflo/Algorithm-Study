import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	static class Meeting implements Comparable<Meeting> {
		private int start;
		private int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		@Override
		public int compareTo(Meeting target) {
			return Integer.compare(this.start, target.getStart());
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Queue<Meeting> reservation = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Meeting meeting = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			reservation.offer(meeting);
		}

		Queue<Meeting> continuing = new PriorityQueue<>(Comparator.comparingInt(Meeting::getEnd));

		int max = 0;
		while (!reservation.isEmpty()) {
			Meeting nextStart = reservation.poll();
			continuing.offer(nextStart);
			while (!reservation.isEmpty() && reservation.peek().getStart() == nextStart.getStart()) {
				continuing.offer(reservation.poll());
			}
			while (!continuing.isEmpty() && continuing.peek().getEnd() <= nextStart.getStart()) {
				continuing.poll();
			}
			max = Math.max(max, continuing.size());
		}

		System.out.println(max);
	}
}
