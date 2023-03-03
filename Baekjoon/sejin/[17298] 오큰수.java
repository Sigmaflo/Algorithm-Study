import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<Integer>();

		N = stoi(br.readLine()); 
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = stoi(st.nextToken());

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
				arr[stack.pop()] = arr[i];
			} 
			stack.push(i);
		}

		while(!stack.isEmpty()){
			arr[stack.pop()] = -1 ;
		}

		for(int i=0;i<N;i++) sb.append(arr[i]).append(' ');
		System.out.println(sb.toString());
	} 

}
