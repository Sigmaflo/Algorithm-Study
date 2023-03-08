import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<Point> a = new ArrayList<Point>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			Point p = new Point(x, y);
			a.add(p);
		}
		
		Collections.sort(a, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.y == o2.y)
					return o1.x - o2.x;
				else 
					return o1.y - o2.y;
			}
		});
		
		int tmp = a.get(0).y, cnt = 0;
		for (int i = 1; i < n; i++) {
			if (tmp <= a.get(i).x) {
				tmp = a.get(i).y;
				cnt++;
			}
		}
		
		System.out.println(cnt + 1);
	}	
}
