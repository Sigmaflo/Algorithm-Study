import java.io.*;
import java.util.*;

public class 시간_여행 {
    static Stack<Integer>[] array;
    static Stack<Integer> stack;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer str;

        int N = Integer.valueOf(br.readLine());

        array = new Stack[N + 1];
        array[0] = new Stack<>();
        stack = new Stack<>();

        for(int i = 1; i <= N; i++){
            str = new StringTokenizer(br.readLine());
            switch (str.nextToken().charAt(0)){
                case 'a':
                    stack.add(Integer.valueOf(str.nextToken()));
                    break;

                case 's':
                    stack.pop();
                    break;

                case 't':
                    stack.clear();
                    stack.addAll(array[Integer.valueOf(str.nextToken()) - 1]);
                    break;
            }

            array[i] = new Stack<>();
            array[i].addAll(stack);
            if(stack.isEmpty()) bw.write("-1");
            else bw.write(String.valueOf(stack.peek()));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
