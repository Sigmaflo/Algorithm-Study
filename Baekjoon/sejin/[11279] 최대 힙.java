import java.util.*;
import java.io.*;
import java.awt.Point;
 
public class Main {

    static int N ;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
 
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        StringBuilder sb = new StringBuilder();
        int now ;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<N;i++){
            now = stoi(br.readLine());
            if(now == 0){
                if(pq.size()>0){
                    sb.append(pq.poll()+"\n");
                }else{
                    sb.append("0\n");
                }
                
            }else pq.add(now);
        }
        
        System.out.print(sb);

    }
}
