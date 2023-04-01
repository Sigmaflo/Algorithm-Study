import java.util.*;
import java.io.*;
 
 
class Robot{
    int x,y,dist;
 
    public Robot(int x,int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
 
 
public class Main {
 
    static int K,N ;
    static long[] arr ;
    static PriorityQueue<Long> pq ;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
 
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = stoi(st.nextToken()); // K개의 소수
        N = stoi(st.nextToken()); // N번째 오는 것
        arr = new long[K];
        pq = new PriorityQueue<Long>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            arr[i] = stoi(st.nextToken());
            pq.add(arr[i]);
        }

        long now = 0 ;
        
        while(N-->0){
            now = pq.poll();

            for(int i=0;i<K;i++){
                if(now*arr[i] > Long.MAX_VALUE-1) continue;

                pq.add(now*arr[i]);
                if(now%arr[i] == 0 ) break;
            }
        }

        System.out.println(now);
        


    }
}
