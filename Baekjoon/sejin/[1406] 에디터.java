import java.util.*;
import java.io.*;

public class Main {
 
    static String[] str ;
    static int M ;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }
 
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().split("");
        M = stoi(br.readLine());

        Deque<String> left = new ArrayDeque<>();
        for(int i=0;i<str.length;i++) left.add(str[i]);
        Deque<String> right = new ArrayDeque<>();

        StringTokenizer st ;
        String move ;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            move = st.nextToken();
            switch(move){
                case "L":
                    if(left.size()>0){
                        right.addFirst(left.pollLast());
                    }
                    break;

                case "D":
                    if(right.size()>0){
                        left.add(right.pollFirst());
                    }
                    break;
                
                case "B":
                    if(left.size()>0){
                        left.pollLast();
                    }
                    break;
                
                case "P":
                    left.addLast(st.nextToken());
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!left.isEmpty())sb.append(left.poll());
        while(!right.isEmpty())sb.append(right.poll());
        System.out.print(sb);

    }
}
