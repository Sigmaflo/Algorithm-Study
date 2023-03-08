import java.io.*;
import java.util.*;

class lectureRoom implements Comparable<lectureRoom>{
	int start, end ;
	lectureRoom(int start, int end){
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(lectureRoom o) {
		if(this.end == o.end) return this.start - o.start;
		return this.end - o.end;
	}

}

public class Main{

	static int N;
	static lectureRoom[] room ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N = Integer.parseInt(br.readLine()); // N개의 회의
		room = new lectureRoom[N];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			room[i] = new lectureRoom(stoi(st.nextToken()),  stoi(st.nextToken()));
		}

		Arrays.sort(room); // 빨리 끝나는 시간 순대로 정렬

		int befEnd = room[0].end ; // 제일 빨리 끝나는 강의
		int count = 1 ; 

		// 그 다음 강의부터 
			// 시작시간이 이전 제일 빨리 끝난 강의보다 빠를 때 count ++
		for(int i=1;i<N;i++){
			int nxtStart = room[i].start;
			int nxtEnd = room[i].end;

			if(befEnd <= nxtStart){
				befEnd = nxtEnd;
				count ++ ;
			}
		}


		System.out.println(count);
    }
}
