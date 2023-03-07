import java.io.*;
import java.util.*;

public class 회의실_배정 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int N = Integer.valueOf(br.readLine());
        PriorityQueue<Lecture> lectures = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            int s = Integer.valueOf(str.nextToken());
            int e = Integer.valueOf(str.nextToken());
            lectures.add(new Lecture(s,e));
        }

        int nowTime = 0;
        int cnt = 0;
        while(!lectures.isEmpty()){
            if(lectures.peek().start >= nowTime){
                nowTime = lectures.peek().end;
                cnt++;
            }

            lectures.poll();
        }

        System.out.println(cnt);
    }

    public static class Lecture implements Comparable<Lecture>{
        int start;
        int end;

        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o){
            if(end == o.end) return start - o.start;
            return end - o.end;
        }
    }
}
